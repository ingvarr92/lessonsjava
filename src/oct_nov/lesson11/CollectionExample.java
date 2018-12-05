package oct_nov.lesson11;

import java.util.*;

public class CollectionExample {
    // Сделать задачу номер 6
    public static void main(String[] args) {
        //----------------------------- Java Collections Framework
        //java.util.Collection - это интерфейс все методы надо реализовывать.
//        boolean add(E e);
//        boolean remove (Object o);
//        int size();
//        boolean isEmty();
//        boolean contains (Object o);
//
//        Object[] to Array[];
//        <T> T[] toArray(T[] a);
//        String[] arr = collectionName.toArray (new String[0]);
//        iterator(); что бы ходить по элементом коллекции

        // интерфейс List наследуется то Collections java.util.List
        //предоставляет методы для работы с коллекцией, которая является списком.
//        void add (int ind, E obj);
//        boolean addAll (int ind, Collection<? extends E> col); добавление коллекции целиком
//        E get (int ind);
//        int indexOf(Object o);
//        int lastIndexOf(Object o);
//        E remove(int ind);
//        E set(int ind, E obj);
//        List<E> subList(int start,int end);


        //java.util.set они не могут хранить дублирующие значения. Тоже интерфейс наследует от Collections


        //----------------------Классы

       // ArrayList// Динамически расширяемый массив Дженерик
        ArrayList<String> strList = new ArrayList<>();
     //   strList.ensureCapacity(20);
     //   strList.trimToSize();// удаление пустых элементов
       strList.add("Elem 1");
       strList.add("Elem 2");
       strList.add(0,"Elem 2");
       // удаление элементов
//       strList.remove(1);
//       strList.remove("Elem 2");

        System.out.println(strList.toString());

        Integer[] integers = {23,67,12,90};
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(integers));
        System.out.println(intList.toString());

        for (Integer i: intList){
            System.out.println(i);
        }

        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator "+ iterator.next());
            if (iterator.next() == 12){
                iterator.remove();
            }
        }


        //----------------------LinkedList
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("String 1");
        stringLinkedList.add("String 2");
        stringLinkedList.add("String 3");
        stringLinkedList.add(1,"String 4");

        for (String str : stringLinkedList){
            System.out.println(str);
        }

        // удаление элементов

//        stringLinkedList.poll();// если элемент не найдем он возвращает null
//        stringLinkedList.pollFirst();// если элемент не найдем он возвращает null
//        stringLinkedList.remove();// если элемент не найдем он возвращает NoSuchElementException
//        stringLinkedList.removeFirst();// если элемент не найдем он возвращает NoSuchElementException

        String[] arr1 = stringLinkedList.toArray(new String[0]);
        System.out.println(Arrays.toString(arr1));



//-----------------------------SETs
        // тоже интерфейс в нем не может быть дублирующих значений
        // HashSet - самый быстрый по добавлению и удалению элементов.
        // SortedSet -> TreeSet
        // LinkedHashSet - уступает HashSet но не на много

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Element 1");
        hashSet.add("Element 2");
        hashSet.add("Element 3");
        hashSet.add("Element 3");
        System.out.println(hashSet.toString());

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Element 2");
        treeSet.add("Element 1");
        treeSet.add("Element 3");
        System.out.println(treeSet.toString());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Element 2");
        linkedHashSet.add("Element 1");
        linkedHashSet.add("Element 3");
        System.out.println(linkedHashSet.toString());


//
//        Ввести с клавиатуры 5 слов в список строк.
//        Удалить 3 - ий элемент списка, и вывести оставшиеся элементы в обратном порядке.
        LinkedList<String> linkedList = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5 ; i++){
            linkedList.add (in.nextLine());
        }
        linkedList.remove(2);
        for (int b = linkedList.size()-1; b > -1; b--){
            System.out.println(linkedList.get(b));
        }


//        Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
//        Удалить из множества все числа больше 10.
















    }

}
