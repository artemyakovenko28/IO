package _0_charset;

public class App00 {
    public static void main(String[] args) throws Exception {
        String str = new String(new byte[] {0, 1, 2});
        System.out.println("A".getBytes("UTF-16").length);
        System.out.println("AA".getBytes("UTF-16").length);
    }
}
