package _0_charset;

public class App04 {
    public static void main(String[] args) throws Exception {
        char[] array = Character.toChars(150_000);
        char ch0 = 55378;
        char ch1 = 56816;
        String str = new String(new char[] {ch0, ch1});
        System.out.println(str);
        System.out.println(str.length());
        System.out.println(str.codePointCount(0, 2));
        System.out.println(str.codePointAt(0));
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(1));
    }
}
