package _5_labs._2_stream._4_strategy;

import java.io.IOException;
import java.util.Arrays;

public class BAOSTest {
    public static void main(String[] args) throws IOException {
        BAOSWithStrategyWithoutCopying baos = new BAOSWithStrategyWithoutCopying(2);
        for (int k = 0; k < 20; k++) {
            baos.write((byte) (Math.random() * 10));
        }
        System.out.println(Arrays.toString(baos.toByteArray()));
        baos.showBuffers();
    }
}
