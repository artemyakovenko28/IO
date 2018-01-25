package serialization;

import java.io.*;

public class App00{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(buff);

        out.writeObject("Hello!");
        out.flush();
        out.close();

        byte[] rawData = buff.toByteArray();
        System.out.println(rawData.length);

        ObjectInput input = new ObjectInputStream(new ByteArrayInputStream(rawData));
        System.out.println((String) input.readObject());
    }
}
