package _5_labs._2_stream._2_entity_is_os;

import java.io.IOException;

public interface EntityInput {
    public Person readPerson() throws IOException;

    public Point readPoint() throws IOException;
}
