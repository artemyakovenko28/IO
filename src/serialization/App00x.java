package serialization;

import java.io.*;
import java.util.Arrays;

public class App00x {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(buff);

        out.writeObject("Hello!");
        out.writeObject(new Integer(123));
        out.writeObject(new byte[][] {{0, 1}, {2 ,3}});
        out.flush();
        out.close();

        byte[] rawData = buff.toByteArray();
        System.out.println(rawData.length);
        System.out.println(Arrays.toString(rawData));
        System.out.println(new String(rawData, "UTF-8"));

        ObjectInput input = new ObjectInputStream(new ByteArrayInputStream(rawData));
        System.out.println((String) input.readObject());
        System.out.println((Integer) input.readObject());
        System.out.println(Arrays.deepToString((byte[][])input.readObject()));
    }
}
