package _0_charset;

import java.util.Arrays;

public class App02 {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString("A".getBytes("UTF-8")));
        System.out.println(Arrays.toString("A".getBytes("UTF-16")));
        System.out.println(Arrays.toString("A".getBytes("UTF-16BE")));
        System.out.println(Arrays.toString("A".getBytes("UTF-16LE")));
        System.out.println(Arrays.toString("A".getBytes("UTF-32")));
        System.out.println(Arrays.toString("A".getBytes("UTF-32BE")));
        System.out.println(Arrays.toString("A".getBytes("UTF-32LE")));
    }
}
