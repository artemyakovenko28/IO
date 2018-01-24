package _3_reader_writer;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class _1_Charset {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] rawData = new byte[256];
        for (int i = 0; i < rawData.length; i++) {
            rawData[i] = (byte) (i -128);
        }

        for (String name : Charset.availableCharsets().keySet()){
            System.out.println(new String(rawData, name));
            System.out.println("\n\n");
        }
    }
}
