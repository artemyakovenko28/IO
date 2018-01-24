package _1_InputStream_OutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class App01 {
    public static void main(String[] args) throws IOException {
        InputStream src = new URL("http://").openStream();
//        OutputStream dst = new FileOutputStream("C:/Users/User/Desktop/tmp.html");
        copy(src, System.out);
    }
    public static void copy(InputStream src, OutputStream dst) throws IOException {
        int data = 0;
        while (data != -1) {
            data = src.read();
            dst.write(data);
        }
    }
}
