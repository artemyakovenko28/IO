package _0_charset.example;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class App5 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "\uFF6E"; //"ｮ"
        System.out.println(str.charAt(0));
        System.out.println(Arrays.toString(str.getBytes("UTF-8")));
        System.out.println(Arrays.toString(str.getBytes("UTF-16BE")));
        System.out.println(Arrays.toString(str.getBytes("UTF-32")));
        System.out.println(Arrays.toString(str.getBytes("KOI8")));
        System.out.println(new String(str.getBytes("KOI8"), "KOI8"));
    }
}
