package _0_charset;

import java.util.Arrays;

public class App00x {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString("A".getBytes("UTF-8")));
        System.out.println(Arrays.toString("A".getBytes("UTF-16")));
//        byte[] bytes = "AA".getBytes("UTF-8");
//        System.out.println(Arrays.toString(bytes));
//        String str = new String(bytes, "UTF-8");
//        System.out.println(str);
    }
}
