package lesson1;

public class Task2 {
    public static void main(String[] args) {
        int field = 10;
        int wline = 15;
        int leline = 25;
        int line = wline*leline;
        int mfield = field*100;
        int result = mfield %line;
        System.out.println(result + " метров осталось не занято");


    }
}
