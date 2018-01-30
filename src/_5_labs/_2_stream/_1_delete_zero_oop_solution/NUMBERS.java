package _5_labs._2_stream._1_delete_zero_oop_solution;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class NUMBERS extends State{
    private ByteArrayOutputStream buff = new ByteArrayOutputStream();
    protected NUMBERS(OutputStream out) {
        super(out);
    }

    @Override
    public State next(byte value) throws IOException {
        if (value == 0) {
            //...
        } else {
            //...
        }
        throw new IOException();
    }

    public void finish() throws IOException {
        //...
    }
}
