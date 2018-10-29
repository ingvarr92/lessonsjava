package lesson2;


import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите код. Трехзначное число");

        int code = in.nextInt();//123

        if (code == 123) {
            System.out.println("Вы вошли!");
        } else if (code == 321) {
            System.out.println("Вы вошли как директор. Круто!");
        } else {
            System.out.println("Идите гуляйте");
        }

        int a = 5;
        int b = 7;
        if (a == 5) {
            System.out.println("Совпадение найдено a");

        } else if (b == 7) {
            System.out.println("Совпадение найдено b");
        }

        // switch (оператор выбора)
    /*Scanner in2 = new Scanner(System.in);
        int in3 = in2.nextInt(in2);

    int userTicketNum;
        String prize;
    switch (in3){
        case 33333:
            prize = "Большой приз";
            break;
        case 33334:
        case 33335:
            prize = "Средний приз";
            break;
            case  3333378
                prize = "Малый приз";
            break;
        default:
            prize = "Нет призов";

    }*/


        // while
        int messageCount = 5;
        Scanner in3;
        System.out.println("Введите код");
        int code2;
        while (true) {
            in3 = new Scanner(System.in);
            code2 = in3.nextInt();
            if (code2 == 123) {
                System.out.println("Вы вошли");
                in3.close();
                break;
            } else if (code2 == 345) {
                System.out.println("Вы вошли как");
                in3.close();
            } else {
                System.out.println("Попробуйте еще раз");
            }
        }




        //-------------
        // do while циклл с постусловием
        do{
            System.out.println("First iteration");
        }
        while (false);


        // for () {}

        for (int i =0; i < 11 ; i++){
            if (i%2 == 0) {
                System.out.println("i = " + i);
            }
        }
        for (int i =0; i < 11 ; i++){
            if (i%2 == 0) continue; // прекращает текущую итерацию
                System.out.println("i = " + i);
                // можно назвать цикл "имя:" перед циклом
            // и назвать его после break "имя"

        }


    }
}