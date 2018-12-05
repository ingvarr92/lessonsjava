package oct_nov.lesson14;

import java.util.Arrays;

public class ExceptionExample {

    public static void main(String[] args) {

        //RunTimeExceptions


        int[] arr = new int[5];
        //  arr[10] = 23; //java.lang.ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(arr));

        String str = null;
        //   str.equals("Some"); //java.lang.NullPointerException


        int a = 9;
        int b = 0;
        //  System.out.println(a/b);  java.lang.ArithmeticException:


        //  Integer.parseInt("abc"); //java.lang.NumberFormatException

        // выдаем исключение сами
        //  throw new NumberFormatException("NFS");

        // обработка исключений
        // try-catch

        Object data = "42";
        //Integer intData = (Integer) data; //java.lang.ClassCastException

        try {
            Integer intData = (Integer) data;
            System.out.println("After Exception");

        }
//        catch(ClassCastException e){ // самый старенький вариант
//            System.out.println("exeption: " + e.getMessage());
//        }
//        catch (NumberFormatException e){
//            System.out.println("exeption: " + e.getMessage());
//        }
//        catch (RuntimeException e){ // так он будет обрабатывать все RunTimeException. (Очень много исключений Это родительский класс)
//            System.out.println("exeption: " + e.getMessage());
//        }
        catch (ClassCastException | ArrayIndexOutOfBoundsException e) { // в 7 версии можно объединять и группировать несколько
            System.out.println("exeption: " + e.getMessage());
           // System.out.println(Arrays.toString(e.getMessage()));??????
        }

        //finally необезательный блок


        finally { // для высвобождения ресурсов, закрытия соединений
            System.out.println("Finally");
        }


        System.out.println("some code after exception");


        // -------------------------------Other Exceptions


        //--------------------checked exception
        // такие исключения необходимо обработать либо try-catch ибо пробросить на уровень выше


//        try {
//            throw new Exception("checked exception");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            voidWithException();
        } catch (Exception e) {
         //   e.printStackTrace();
        }

     //   throw new UncheckedException("UncheckedException"); // выкидываем свое исключение можно не обрабатывать

        try {
            voidWithCheckedException();
        } catch (CheckedException e) {
            e.printStackTrace();
        //    throw new UncheckedException("In catch"); // совсем мрак
        }
        System.out.println("some code after exception2");

        //   throw CheckedException("CheckedException"); // необходимо обрабатывать
    }

    public static void voidWithException() throws Exception { // перекидываем на уровень выше
            throw new Exception("checked exception");
        }

            // если вы разрабатываете для разработчиков вам придется писать классы исключениями

public static void voidWithCheckedException() throws CheckedException{ // обязываем разработчика обрабатывать это исключение
        throw new CheckedException("checked exception");
}

/*
пакеты
методы
классы
паблик классов должен быть только один
свойства
аргументы передача параметров
абстрактный класс
интерфейсы
коллекции
массивы
методы Map и Collections какие у них возможности

JVM
JRE JVM + классы жава
JDK все для разработки

----------------ассоциации:
------------- агрегация
------------- композиция

------------- наследование

this
super

autoBoxing

Сколько занимает объект

 */

}
