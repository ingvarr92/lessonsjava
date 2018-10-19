package lesson1;

public class Task5 {
    public static void main(String[] args) {
        double a = 7.6;
        double b = 15.5;
        double c = 10;
        double res1 = c - a;
        double res2 = c - b;
        if (Math.abs(res1) < Math.abs(res2)){
            System.out.println(res1);
        }
        else {
            System.out.println(res2);
        }
    }
}
