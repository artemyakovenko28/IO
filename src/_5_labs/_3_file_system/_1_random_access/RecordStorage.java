package _5_labs._3_file_system._1_random_access;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RecordStorage implements AutoCloseable {
    private static final int INT_SIZE_IN_BYTES = 4;
    private final RandomAccessFile file;

    public RecordStorage(String fileName) throws FileNotFoundException {
        this.file = new RandomAccessFile(fileName, "rw");
    }

    public void write(Record record, int index) throws IOException {
        // seek to record position in file
        file.seek(index * (INT_SIZE_IN_BYTES * 2 + Record.MAX_DATA_LENGTH));
        // write fields
        file.writeInt(record.getId());
        file.writeInt(record.getData().length);
        file.write(record.getData());
    }

    public Record read(int index) throws IOException {
        // seek to record position in file
        file.seek(index * (INT_SIZE_IN_BYTES * 2 + Record.MAX_DATA_LENGTH));
        // read fields
        int id = file.readInt();
        int dataLength = file.readInt();
        byte[] data = new byte[dataLength];
        file.read(data);
        // return
        return new Record(id, data);
    }

    public void flush() throws IOException {
        file.getChannel().force(true);
        file.getFD().sync();
    }

    @Override
    public void close() throws IOException {
        file.close();
    }
}
