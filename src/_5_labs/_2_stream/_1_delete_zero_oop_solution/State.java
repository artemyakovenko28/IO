package _5_labs._2_stream._1_delete_zero_oop_solution;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class State {
    protected final OutputStream out;

    public State(OutputStream out) {
        this.out = out;
    }

    public abstract State next(byte value) throws IOException;

    public void finish() throws IOException {

    }

    public static void filter(InputStream in, OutputStream out, int buffSize) throws IOException {
        byte[] buff = new byte[buffSize];
        int count;
        while ((count = in.read(buff)) != -1) {
            State state = new ZERO(out);
            for (int index = 0; index < count; index++) {
                state = state.next(buff[index]);
            }
            state.finish();
        }
    }


}
