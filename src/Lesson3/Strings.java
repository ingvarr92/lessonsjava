package Lesson3;

import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        String str = "String";// массив с символами

        String str2 = new String("String");
        "String".length();// здесь будет создан объект

        String str3 = String.format("String %02d",9); // тратит много ресурсов
        System.out.println(str3);

        String str4 = "String String";
        String str5 = "String";

        System.out.println(str == str2);// false
        System.out.println(str == str5);// true

        //строки можно сравнивать только посимвольно

        System.out.println(str.equals(str2));//true
        System.out.println(str.equals(str5));//true

        String str6 ="StrinG";

        System.out.println(str.equalsIgnoreCase(str6));
        System.out.println(str.equals(str6));
        System.out.println(str.startsWith("S")); // начала
        System.out.println(str.endsWith("ng"));// окончания


        String str10 ="string";
        String str11 =new String("string");
        String str12 ="str";
        String str13 ="String string";
        System.out.println(str10.compareTo(str11));
        System.out.println(str11.compareTo(str12));
        System.out.println(str11.compareTo(str13));


        // сравнение по символьно по коду символа
        // возвращает число 0 если строчки равны

        // если первая строка больше то результат положительный

        // если первая строка меньше результат отрицательный

        System.out.println(str11.compareToIgnoreCase(str13)); // сравнение без учета регистра

        // сортировка строк

        String a = "Astring";
        String b = "QBstring";
        String c = "Cstring \n \"строка\""; // экранирование спец символов \

        String[] strArr = {a,b,c};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
        System.out.println(c);

        System.out.println(a.substring(2, 4));// взятие подстроки возмет строчку с 3 элемента

        System.out.println(a.contains("str")); // искомая строчка в строке найдена тогда true

        String[] arr = {"qwe", "rty", "yui"};

        String string = "First ";
        String string2 = "Second ";
        String string3 = "Third";
        string2 += string; // "Second" + "First"
        System.out.println(string + string2 + string3 );

        for (int i = 0; i < 10; i++){
            string += string2;
            System.out.println(string);
        }
        System.out.println(string);

        //StringBuffer | StringBuilder

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);//добавляем в него строчку
        System.out.println(stringBuilder);

        for (int i = 0 ; i < 10 ; i++){
            stringBuilder.append("string").append(" str ");
        }
        System.out.println(stringBuilder.toString());


    }
}
