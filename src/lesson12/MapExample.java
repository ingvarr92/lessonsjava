package lesson12;

import java.util.*;

public class MapExample {

    // hashCode можно переопределять. Перезаписать метод getHashCode()
    // он должен быть одинаковым у одного объекта
    // Хэшкод может быть одинаковым для разных объектов.

    // Он генерируется по своему на каждой машине. Его лучше переопределять.
    public static void main(String[] args) {
        User user = new User (1, "First");
    // System.out.println(user.hashCode());
// Реализация Map
//        HashMap  хранение на основе Хэшкодов
//        TreeMap
//        EnumMap
//        LinkedHashMap Хранит в последовательности добавления

//        WeakHashMap
//        IdentityHashMap

        Map<Integer,String> hashMap = new HashMap<>(); // Ключ (уникальный) | значение
        hashMap.put(1,"Elem 1");
        hashMap.put(2,"Elem 2");
        hashMap.put(2,"Elem 3");
        hashMap.put(null,"Elem null"); // null приходит на первое место
        hashMap.put(null,"Elem null2"); // null приходит на первое место

        System.out.println(hashMap);
        System.out.println(hashMap.get(2));

        // перебрать элементы Map

        for (Map.Entry entry : hashMap.entrySet()) { // каждая пара храниться в отдельном объекте Entry
            System.out.println("Key " + entry.getKey() + " Value " + entry.getValue());
        }



        Map<Integer,String> linkedHashMap = new LinkedHashMap<>(); // Объекты храняться в порядке добавления
        linkedHashMap.put(1,"Elem 1");
        linkedHashMap.put(2,"Elem 2");
        linkedHashMap.put(2,"Elem 3");
        linkedHashMap.put(null,"Elem null");
        System.out.println(linkedHashMap);


        Map<Integer,String> treeMap = new TreeMap<>(); //
        treeMap.put(4,"Elem 1");
        treeMap.put(2,"Elem 1");
        treeMap.put(2,"Elem 2");
        treeMap.put(0,"Elem null"); // не может хранить null
        System.out.println(treeMap);


    }
}
