package oct_nov.lesson12;

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
        System.out.println(hashMap.keySet()); // set ключей
        System.out.println(hashMap.values()); // set значений


        for (Map.Entry entry : hashMap.entrySet()) { // каждая пара храниться в отдельном объекте Entry
            System.out.println("Key " + entry.getKey() + " Value " + entry.getValue());
        }



        Map<Integer,String> linkedHashMap = new LinkedHashMap<>(); // Объекты храняться в порядке добавления
        linkedHashMap.put(1,"Elem 1");
        linkedHashMap.put(2,"Elem 2");
        linkedHashMap.put(2,"Elem 3");
        linkedHashMap.put(null,"Elem null");
        System.out.println(linkedHashMap);


        Map<Integer,String> treeMap = new TreeMap<>(); // сортируются по значению по красно-черному бинарному дереву
        treeMap.put(4,"Elem 1");
        treeMap.put(2,"Elem 1");
        treeMap.put(2,"Elem 2");
        treeMap.put(0,"Elem null"); // не может хранить null
        System.out.println(treeMap);


        /*
        правила бинарного дерева
        корень - верхний уровень
        листья - узлы без потомков
        Значения левого  потомка должно быть меньше родителя
        Значения правого потомка должно быть больше родителя или ровно

        красно-черное бинарное дерево (его вариация)
        корень и листья всегда черные
        каждый красный узел имеет 2 черных потомка
        Все пути от узла (корня) до листьев должны иметь одинаковое количество черных узлов

        */


        User user1 = new User(1,"Вася");
        User user2 = new User(2,"Саша");
        User user3 = new User(3,"Женяняняня");
        User user4 = new User(4,"ЖеняB");
        Map <Integer, User> userTreeMap = new TreeMap<>();
        userTreeMap.put(1,user1);
        userTreeMap.put(2,user2);
        userTreeMap.put(3,user3);
        System.out.println(userTreeMap);

        TreeSet<User> userTreeSet = new TreeSet<>();
        userTreeSet.add(user1);
        userTreeSet.add(user2);
        userTreeSet.add(user3);
        userTreeSet.add(user4);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(userTreeSet);
        System.out.println(userTreeSet);

       // TreeMap<Integer, String> treeMap1 = new TreeMap<>(hashMap);
        //System.out.println(treeMap1);

        Map <String, Integer> map = new HashMap();

        //map.remove()

    }
}
