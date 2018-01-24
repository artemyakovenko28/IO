package _1_InputStream_OutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class App02 {
    public static void main(String[] args) throws IOException {
        InputStream src = new URL("http://google.com").openStream();
//        OutputStream dst = new FileOutputStream("C:/Users/User/Desktop/tmp.html");
        copy(src, System.out);
    }
    private static void copy(InputStream src, OutputStream dst) throws IOException {
        byte[] buff = new byte[64 * 1024];
        int count;
        while (true) {
            count = src.read(buff);
            dst.write(buff, 0, count);
            if (count == -1) return;
        }
    }
}
