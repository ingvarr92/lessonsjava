package oct_nov.lesson7.memberInner;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        Iterator iterator = myArray.Iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
