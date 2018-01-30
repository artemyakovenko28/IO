package _5_labs._2_stream._2_entity_is_os;

import java.io.IOException;

public interface EntityOutput {
    public void writePerson(Person person) throws IOException;

    public void writePoint(Point point) throws IOException;

    public void flush();

    public void close();
}
