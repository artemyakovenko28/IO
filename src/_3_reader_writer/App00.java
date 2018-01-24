package _3_reader_writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class App00 {
    public static void main(String[] args) throws IOException {
//        String str = "Hello!";
//        char[] chars = str.toCharArray();
//        try (OutputStream dst = new FileOutputStream(new File("d:/tmp.txt"))) {
//            Writer writer = new OutputStreamWriter(dst, "UTF-8");
//            writer.write(str);
//            writer.flush();
//        }
        Reader reader = new InputStreamReader(System.in);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
    }
}
