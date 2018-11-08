package lesson9.storage;

import lesson9.classes.Book;

import java.util.LinkedList;


public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Pair<Integer,String> pair = new Pair<>(6,"ТЕСТ");// Генерики не могут работать с примитивными типами данных
        Integer key = pair.getKey();
        String value = pair.getValue();
        Book book1 = new Book ("BLaBla", 90);
        Pair<String, Book> pair1 = new Pair<String, Book>("Value", book1);
        Book book = pair1.getValue();
//-------------------- shift + F6  замена название переменной, метода и класса всезде в пределах видимости
    }



}
