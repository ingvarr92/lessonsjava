package lesson11;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Next {

    //        Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
    //        Удалить из множества все числа больше 10.
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
       for (int i = 0; i < 20; i++){
           hashSet.add(i);
       }
        Iterator<Integer> iterator = hashSet.iterator();
       while (iterator.hasNext()){
           if (iterator.next() > 10){
               iterator.remove();
           }
       }
        System.out.println(hashSet.toString());


    //    File txtFile = new File("Lesson11/file.txt");




    }

}
