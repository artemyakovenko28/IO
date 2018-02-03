package _5_labs._2_stream._1_delete_zero;

import _5_labs._2_stream._4_strategy.BAOSWithStrategyWithoutCopying;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class DeleteZeroLab {
    public static void filterElem(InputStream in, OutputStream out) throws IOException {
        while (true) {
            int value = in.read();
            if (value > 0) {
                out.write(value);
            } else if (value == -1) {
                break;
            }
        }
    }

    public static void filterBuff(InputStream in, OutputStream out, int buffSize) throws IOException {
        final int ZERO_STATE = 0;
        final int NUMBERS_STATE = 1;
        byte[] buff = new byte[buffSize];
        int state = ZERO_STATE;
        int count;
        while ((count = in.read(buff)) != -1) {
            int from = 0;
            int len = 0;
            for (int index = 0; index < count; index++) {
                switch (state) {
                    case ZERO_STATE:
                        if (buff[index] == 0) {
                            state = ZERO_STATE;
                        } else {
                            from = index;
                            len++;
                            state = NUMBERS_STATE;
                        }
                        break;
                    case NUMBERS_STATE:
                        if (buff[index] == 0) {
                            out.write(buff, from, len);
                            state = ZERO_STATE;
                        } else {
                            len++;
                            state = NUMBERS_STATE;
                        }
                        break;
                }

            }
            if (state == NUMBERS_STATE) {
                out.write(buff, from, len);
                out.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        byte[] data = {1, 0, 1, 0,   1, 1, 1, 0,   0, 0, 1, 1,   1, 1}; //9 - not ok
//        byte[] data = {1, 0, 1, 1,   0, 0, 0, 0,   1, 1, 1, 1,   0, 1, 1, 0}; // ArrayIndexOutOfBoundsException
        byte[] data = {0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0}; //4 - ok
        ByteArrayInputStream in = new ByteArrayInputStream(data);
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BAOSWithStrategyWithoutCopying out = new BAOSWithStrategyWithoutCopying();
//        out.write(data, 1, 2);
//        System.out.println(Arrays.toString(out.toByteArray()));
        filterBuff(in, out, 4);
        System.out.println(Arrays.toString(out.toByteArray()));
        System.out.println(out.toByteArray().length);
    }
}
