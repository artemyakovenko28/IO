package _2_decorator;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

class App10 {
    public static void main(String[] args) throws IOException {
        OutputStream dst = new ByteArrayOutputStream();
        dst = new LogOutputStream(dst, "AFTER");
        dst = new BufferedOutputStream(dst, 2);
        dst = new LogOutputStream(dst, "BEFORE");
        dst.write(1);
        dst.write(2);
        dst.write(3);
        dst.write(4);
        dst.write(5);
        dst.flush();
    }
}

public class LogOutputStream extends OutputStream {

    private final OutputStream impl;
    private final String name;

    public LogOutputStream(OutputStream impl, String name) {
        this.impl = impl;
        this.name = name;
    }

    @Override
    public void write(int b) throws IOException {
        System.out.println(name + ":write(" + b + ")");
        impl.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println(name + ":write(" + Arrays.toString(b) + ")");
        impl.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.println(name + ":write(" + Arrays.toString(b) + ", " + off + ", " + len + ")");
        impl.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        System.out.println(name + "flush");
        impl.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }
}
