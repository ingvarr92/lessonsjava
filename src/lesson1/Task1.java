package lesson1;

public class Task1 {
    public static void main (String [] args){
        int le = 8;
        int wi = 8;
        int hi = 10;
        int s = 2 * (le *wi + le * hi + wi * hi);
        System.out.println("Площадь параллелепипеда " + s);
                if (le < wi) {
                    System.out.println("Длинна больше");
                }
                else if (wi < le){
                    System.out.println("Высота больше");
                }
                else {
                    System.out.println("Это квадрат");
                }
       //boolean a = (le < wi) ? (System.out.println()):(System.out.println());

    }

}
