package _5_labs._2_stream._1_delete_zero_oop_solution;

import java.io.IOException;
import java.io.OutputStream;

public class ZERO extends State {
    public ZERO(OutputStream out) {
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
