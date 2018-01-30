package _5_labs._2_stream._2_entity_is_os;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestPersonMany {
    public static void main(String[] args) throws IOException {
        // PREPARE
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        EntityOutput out = new EntityOutputStream(buff);
        for (int index = 0; index < 10; index++) {
            out.writePerson(new Person("Mike_" + index, index));
        }
        byte[] rawBytes = buff.toByteArray();

        EntityInput entityInput = new EntityInputStream(new ByteArrayInputStream(rawBytes));
        for (int index = 0; index < 10; index++) {
            // CALL
            Person person = entityInput.readPerson();
            // CHECK
            if (!person.getName().equals("Mike_" + index)) {
                throw new AssertionError();
            }
            if (person.getAge() != index) {
                throw new AssertionError();
            }
        }
    }
}
