package _0_charset;

import java.io.UnsupportedEncodingException;

public class AppXXX {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {-100, -101, -102};
        System.out.println(new String(bytes, "UTF-8"));
        System.out.println(new String(bytes, "cp1251"));
        System.out.println(new String(bytes, "ASCII"));
    }
}
