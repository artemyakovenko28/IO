package _0_charset;

public class App01 {
    public static void main(String[] args) throws Exception {
        System.out.println("ЭЮЯ".getBytes("UTF-8").length);
        System.out.println("ЭЮЯ".getBytes("cp1251").length);
    }
}
