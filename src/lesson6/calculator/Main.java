package lesson6.calculator;

public class Main {
    public static void main(String[] args) {
        int a = 9;
        int b = 9;
        Operation plus = new Plus(a,b);
        plus.execute(); // 10

        Operation minus = new Minus (a,b);
        minus.execute ();// 8

        Operation divide = new Divide(a,b);
        divide.execute();

        Operation multiplication = new Multiplication(a,b);
        multiplication.execute();

    }
}
