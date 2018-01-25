package serialization;

import java.io.*;
import java.util.Arrays;

public class App01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(buff);

        out.writeObject(new PersonD("Mike", 45, new Address("street")));
        out.flush();
        out.close();

        byte[] rawData = buff.toByteArray();
        System.out.println(Arrays.toString(rawData));
        System.out.println(new String(rawData, "UTF-8"));

        ObjectInput input = new ObjectInputStream(new ByteArrayInputStream(rawData));
        PersonD person = (PersonD) input.readObject();
        System.out.println(person.toString());
    }
}
