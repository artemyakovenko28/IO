package _5_labs._2_stream._4_strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BAOSWithStrategyWithoutCopying extends OutputStream {
    private static final int DEFAULT_START_SIZE = 16;
    private static final AllocateStrategy DEFAULT_ALLOCATE_STRATEGY = new DoubleAllocateStrategy();
    private final AllocateStrategy strategy;
    private List<byte[]> bufferList = new ArrayList<>();
    private int countOfBytesWrittenToLastBuff = 0;

    public BAOSWithStrategyWithoutCopying() {
        this(DEFAULT_START_SIZE, DEFAULT_ALLOCATE_STRATEGY);
    }

    public BAOSWithStrategyWithoutCopying(int startSize) {
        this(startSize, DEFAULT_ALLOCATE_STRATEGY);
    }

    public BAOSWithStrategyWithoutCopying(AllocateStrategy strategy) {
        this(DEFAULT_START_SIZE, strategy);
    }

    public BAOSWithStrategyWithoutCopying(int startSize, AllocateStrategy strategy) {
        bufferList.add(new byte[startSize]);
        this.strategy = strategy;
    }

    @Override
    public void write(int b) throws IOException {
        byte[] lastBuff = bufferList.get(bufferList.size() - 1);
        if (countOfBytesWrittenToLastBuff == lastBuff.length) {
            int newSize = strategy.nextAfter(lastBuff.length);
            byte[] newLastBuff = new byte[newSize];
            bufferList.add(newLastBuff);
            countOfBytesWrittenToLastBuff = 0;
            lastBuff = newLastBuff;
        }
        lastBuff[countOfBytesWrittenToLastBuff++] = (byte) b;
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte[] lastBuff = bufferList.get(bufferList.size() - 1);
        int remainingPlaceInLastBuff = lastBuff.length - countOfBytesWrittenToLastBuff;
        int needToWriteToNewLastBuff = b.length - remainingPlaceInLastBuff;

        if (remainingPlaceInLastBuff < b.length) {
            System.arraycopy(b, 0, lastBuff, countOfBytesWrittenToLastBuff, remainingPlaceInLastBuff);
            int newSize = lastBuff.length;
            while (needToWriteToNewLastBuff > newSize) {
                newSize = strategy.nextAfter(newSize);
            }
            byte[] newLastBuff = new byte[newSize];
            bufferList.add(newLastBuff);
            countOfBytesWrittenToLastBuff = 0;
            lastBuff = newLastBuff;
            System.arraycopy(b, remainingPlaceInLastBuff, lastBuff, 0, needToWriteToNewLastBuff);
            countOfBytesWrittenToLastBuff += needToWriteToNewLastBuff;
        } else {
            System.arraycopy(b, 0, lastBuff, countOfBytesWrittenToLastBuff, b.length);
            countOfBytesWrittenToLastBuff += b.length;
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }

        byte[] newArray = new byte[len - off];
        System.arraycopy(b, off, newArray, 0, len - off);
        write(newArray);
    }

    public void writeTo(OutputStream out) throws IOException {
        for (int i = 0; i < bufferList.size() - 1; i++) {
            byte[] currentBuff = bufferList.get(i);
            out.write(currentBuff);
        }

        byte[] lastBuff = bufferList.get(bufferList.size() - 1);
        out.write(lastBuff, 0, countOfBytesWrittenToLastBuff);
    }

    public byte[] toByteArray() {
        int totalSize = 0;
        byte[] currentBuffer;
        for (int i = 0; i < bufferList.size() - 1; i++) {
            currentBuffer = bufferList.get(i);
            totalSize += currentBuffer.length;
        }
        totalSize += countOfBytesWrittenToLastBuff;

        int index = 0;
        byte[] result = new byte[totalSize];
        for (int i = 0; i < bufferList.size() - 1; i++) {
            currentBuffer = bufferList.get(i);
            System.arraycopy(currentBuffer, 0, result, index, currentBuffer.length);
            index += currentBuffer.length;
        }

        byte[] lastBuff = bufferList.get(bufferList.size() - 1);
        System.arraycopy(lastBuff, 0, result, index, countOfBytesWrittenToLastBuff);
        return result;
    }

    public void showBuffers() {
        for (byte[] elem : bufferList) {
            System.out.println(Arrays.toString(elem));
        }
    }

    @Override
    public void flush() throws IOException {
        super.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }
}
