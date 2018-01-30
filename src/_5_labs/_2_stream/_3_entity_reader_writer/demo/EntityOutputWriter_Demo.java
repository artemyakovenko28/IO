package _5_labs._2_stream._3_entity_reader_writer.demo;

import labs._2_stream._2_entity_is_os.Person;
import labs._2_stream._2_entity_is_os.Point;
import labs._2_stream._3_entity_reader_writer.EntityOutputWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class EntityOutputWriter_Demo {
    public static void main(String[] args) throws IOException {
        EntityOutputWriter entityOutput = new EntityOutputWriter(new OutputStreamWriter(System.out));
        entityOutput.writePoint(new Point(4, 8));
        entityOutput.writePerson(new Person("Anna", 25));
        entityOutput.writePoint(new Point(0, 0));
        entityOutput.writePerson(new Person("Mike", 45));
    }
}
