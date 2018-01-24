package _2_decorator;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class App00 {
    public static void main(String[] args) throws IOException {
        OutputStream dst = new FileOutputStream("C:/Users/User/Desktop/tmp.txt");
        dst = new BufferedOutputStream(dst, 8 * 1024);
        dst = new GZIPOutputStream(dst);
    }
}
