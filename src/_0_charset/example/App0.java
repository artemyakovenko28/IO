package _0_charset.example;

public class App0 {
    public static void main(String[] args) {

        String str0 = "\u0FFF\u0FFF";
        String str1 = new String(new char[] {0xFFF, 0xFFF});
        //str0.equals(str1) == true;
        printChar();
        printShort();
    }

    private static void printChar() {
        int c0 = 0xFFFF;
        char c1 = '\uFFFF';
        System.out.println((int) c0);
        System.out.println((int) c1);
    }

    private static void printShort() {
        short s = -32768; //Short.MIN_VALUE;
        System.out.println(Integer.toBinaryString(s));
    }
}
