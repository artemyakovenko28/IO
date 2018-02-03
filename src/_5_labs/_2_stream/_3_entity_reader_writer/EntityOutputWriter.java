package _5_labs._2_stream._3_entity_reader_writer;

import _5_labs._2_stream._2_entity_is_os.EntityOutput;
import _5_labs._2_stream._2_entity_is_os.Person;
import _5_labs._2_stream._2_entity_is_os.Point;

import java.io.IOException;
import java.io.Writer;

public class EntityOutputWriter implements EntityOutput{
    private final Writer out;

    public EntityOutputWriter(Writer out) {
        this.out = out;
    }
    @Override
    public void writePerson(Person person) throws IOException {
        int age = person.getAge();
        String name = person.getName();
        out.write("<person>\n");
        out.write("     <age>" + age + "</age>\n");
        out.write("     <name>" + name + "</name>\n");
        out.write("</person>\n");
        out.flush();
    }

    @Override
    public void writePoint(Point point) throws IOException {
        out.write("<point x='" + point.getX() + "' y='" + point.getY() + "'</point>\n");
        out.flush();
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() {

    }
}
