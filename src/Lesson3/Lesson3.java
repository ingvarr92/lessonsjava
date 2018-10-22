package Lesson3;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        //---------------------------Массивы
        // Неприрывная область памяти в которой мы можем хранить элементы.
        // Элементы в массиве храняться под номерами. Номерация насинается с нуля.
        // У него есть свойство длинна.
        // Arrays class
        int[] arr; // объявление переменной массива
        int arr1 [];// тоже работает но не принято
        arr = new int[10]; // он заполнен значениями по умолчанию из 10 элементов
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        int a = 2;
        int[] arr3 = {2,12,34,55555,45,93,6,776,797,5646, a}; // создание и заполнение массива
        System.out.println(Arrays.toString(arr3));

        System.out.println(arr3[1+2]);// 55555
        System.out.println(arr3[1+2]);// ctrl+D копирование строчки
        //System.out.println(arr3[11+2]);//  ArrayIndexOutOfBoundsException

        arr[1] = 123; //изминение значения элемента массива


        for (int i = 0; i < arr.length; i++) { // заполнение массива циклом
           arr[i] = i + 10;
        }
        System.out.println(Arrays.toString(arr));

        // копирование массива

        int[] arr4 = {2,6,7,8,10};
        int [] arr5 = arr4; //так скопировать нельзя теперь у массива два имени

        int [] cloneArr4 = arr4.clone(); // он создает полный клон массива
        //--------------System.arraycopy(srcArr(исходный массив),
        // int srcPos(с какого элемента копировать),
        // destArr(новый масс),
        // int destPos (позиция начала копирования),
        // int length(длинна копирования));

        int[] arr6 = new int[10];
        System.arraycopy(arr4,  1, arr6 , 2 ,  2);
        System.out.println(Arrays.toString(arr6));


        // еще один метод копирования
        int [] copArr4 = Arrays.copyOf(arr4, 3);

        System.out.println( Arrays.toString(copArr4));


        int [] copyRangeArr4 = Arrays.copyOfRange(arr4, 1 , 4);// включает первое число и исключает второе
        System.out.println(Arrays.toString(copyRangeArr4)); // [6, 7, 8]



        arr4 = new int[] {4,6,7,8,9,10,56};
        // перебрать все значения массива в цикле for

        for (int i = 0; i < arr4.length; i++){
            arr4[i] += 100;
        }
        System.out.println(Arrays.toString(arr4));

        for (int num: arr4){
            System.out.println("num = " + num); // переменнй num присваивается поочередно значения элементов массива
        }



        // Сравнивание массивов
        arr4 = new int[] {4,6,7,8,9,10,56};
        arr5 = new int[] {4,6,7,8,9,10,56};

        System.out.println( arr4 == arr5); // false
        System.out.println(arr4.equals(arr5)); // false

        // массива нужно сравнивать по элементно

        System.out.println(Arrays.equals(arr4, arr5)); // true

        int [] arr7 = new int[14];
        Arrays.fill(arr7, 233); // наполняет массив заданным числом
        System.out.println(Arrays.toString(arr7));

        arr7 = new int [] {34, -1, -90,154, 67};
        Arrays.sort(arr7, 1,4);// отсортирует указанные элементы
        System.out.println(Arrays.toString(arr7));

        Arrays.sort(arr7);// отсортирует все элементы
        System.out.println(Arrays.toString(arr7));
        // поиск вернет индекс найденного элемента
        System.out.println(Arrays.binarySearch(arr7,3)); //поиск в массиве если элемента нет, то он вернет с отрицательным значением место где он мог бы быть



        //------------------------------ СТРОКИ



    }
}
