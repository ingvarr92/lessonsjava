package lesson1;

public class Task5 {
    public static void main(String[] args) {
        double a = 7.6;
        double b = 15.5;
        double c = 10;
        double res1 = c - a;
        double res2 = c - b;
        if (Math.abs(res1) < Math.abs(res2)){
            System.out.println(a);
        }
        else {
            System.out.println(b);
        }

        // другой вариант с тиральным оператором
        double answer = (res1 > res2) ? a : b;
        System.out.println(answer);
    }
}
