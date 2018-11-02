package lesson7.memberInner;

import java.util.Iterator;

public class MyArray {
    private Object[] array;
    public MyArray(){// Конструктор
        array = new Object[10];
        for (int i = 0; i < array.length; i++){
            array[1] = String.valueOf(i);
        }
    }
    public EvenIterator Iterator (){
        return new EvenIterator();
    }


    private class EvenIterator implements Iterator{
        private int nextIndex;

        @Override
        public boolean hasNext() {

            return nextIndex < array.length;
        }

        @Override
        public Object next() {
            Object next = array[nextIndex];
            nextIndex += 2;
            return next;
        }
    }



}
