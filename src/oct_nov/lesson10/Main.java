package oct_nov.lesson10;

import static java.lang.Long.valueOf;

public class Main {
    public static void main(String[] args) {
        Byte b1 = new Byte("1");
        System.out.println(b1.doubleValue());
        Short s1 = new Short("1");
        Short s2 = new Short("200");
        System.out.println(s1.equals(b1));
        //s1.compareTo(b1);
        System.out.println(s1.doubleValue());
        System.out.println(s1.compareTo(s2));
        Long a = valueOf(1);
        System.out.println(Double.longBitsToDouble(a));

    }
}
