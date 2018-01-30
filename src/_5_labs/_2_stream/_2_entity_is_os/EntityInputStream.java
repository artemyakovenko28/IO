package _5_labs._2_stream._2_entity_is_os;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EntityInputStream implements EntityInput{
    private final DataInput in;
    public EntityInputStream(InputStream in) {
        this.in = new DataInputStream(in);
    }

    @Override
    public Person readPerson() throws IOException {
        Person person;
        int age = in.readInt();
        boolean nameExists = in.readBoolean();
        if (nameExists == false) {
            person = new Person(null, age);
        } else {
            String name = in.readUTF();
            person = new Person(name, age);
        }

        return person;
    }

    @Override
    public Point readPoint() throws IOException {
        int x = in.readByte();
        int y = in.readByte();
        return new Point(x, y);
    }
}
