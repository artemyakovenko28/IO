package _5_labs._2_stream._3_entity_reader_writer;

import _5_labs._2_stream._2_entity_is_os.EntityInput;
import _5_labs._2_stream._2_entity_is_os.Person;
import _5_labs._2_stream._2_entity_is_os.Point;

import java.io.IOException;
import java.io.Reader;

public class EntityInputReader implements EntityInput {
    private final Reader in;

    public EntityInputReader(Reader in) {
        this.in = in;
    }


    @Override
    public Person readPerson() throws IOException {
        Person person;

        return null;
//        int age = person.getAge();
//        String name = person.getName();
//        out.write("<person>\n");
//        out.write("     <age>" + age + "</age>\n");
//        out.write("     <name>" + name + "</name\n");
//        out.write("</person\n");
//        out.flush();
    }

    @Override
    public Point readPoint() throws IOException {
        return null;
    }
}
