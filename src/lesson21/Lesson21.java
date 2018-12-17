package lesson21;

import java.util.ArrayList;
import java.util.List;

public class Lesson21 {
    // синхронизация многопоточной системы

    public static void main(String[] args) throws InterruptedException {
        Sync sync = new Sync();
        List<Sync.Adder> adderList = new ArrayList<>(100);

        // cоздаем потоки
        for (int i = 0; i<100; i++){
            adderList.add (sync.new Adder());
        }
        // запускаем потоки
        for (Sync.Adder adder: adderList){
            adder.start();
        }

        // ждем завершения
        for(Sync.Adder adder: adderList){
            adder.join();
        }


        System.out.println("Result: "+ sync.counter);
    }

}
// общий участок памяти
// который будем изменять из разных потоков
class Sync{
    int counter;
private synchronized void increment() { // синхронизированный метод на текущем объекте
    counter++;
}

    public class Adder extends Thread{
        @Override
        public void run(){
            for (int i = 0;i<100_000; i++){
                //counter++;
//                synchronized (Sync.this){// объект на котором происходит операция
//                    // все что в этом блоке выполнять может только один поток
//                    counter++;
                    increment();
            }
        }
    }
}
class  Storage {
    int bookCount = 0;

public synchronized void getBook() throws InterruptedException {
    System.out.println("START getBook");

    while (bookCount < 1 ){ // условие на случай если поток проснется неожиданно Это может произойти в любой момент
        wait();
    }
    bookCount--;
    System.out.println("Одну книгу взяли из библиотеки");
    System.out.println("В библиотеке осталось: "+ bookCount);
    notify(); // он сообщит что объект свободен одному случайному потоку, есть еще notifyAll() он разбудит все спящие потоки
    System.out.println("END getBook");
}


public synchronized void putBook() throws InterruptedException {
    System.out.println("START putBook");
    while (bookCount >=5){ // условие на случай если поток проснется неожиданно Это может произойти в любой момент
        wait();
    }
    bookCount++;
    System.out.println("В библиотеку добавили одну книгу");
    System.out.println("В библиотеке: " + bookCount);
    notify();
    System.out.println("END putBook");
}
}

class Put implements  Runnable{
    Storage storage;
    public Put (Storage storage){
        this.storage = storage;
    }


    @Override
    public void run() {
        for (int i = 1; i <10; i++) {
            try {
                storage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Get implements Runnable{

    Storage storage;

    public Get(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 1; i <10; i++) {
            try {
                storage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Library {
    public static void main(String[] args) {
//        Storage storage = new Storage();
//
//        Put put = new Put(storage);
//        Get get = new Get(storage);
//        new Thread(put).start();
//        new Thread(get).start();

        // new Thread(new Put).start();


//           Взаимная блокировка

        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                synchronized (obj1) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 1 locked obj1");
                    synchronized (obj2) {
                        System.out.println("Thread 1 locked both obj");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                synchronized (obj2) {
                    System.out.println("Thread 2 locked obj2");
                    synchronized (obj1) {
                        System.out.println("Thread 2 locked both obj");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

//ДЗ 1
//Runtime.getRuntime().availableProcessors(); получение количества процессоров

// считали файл в коллекцию
// каждый поток считает свою часть коллекции
// каждый поток работает со своей мапой и потом добавляет в общюю


//