package lesson22;

import java.util.*;
import java.util.concurrent.*;

public class SomeClass {

    private static volatile boolean run = true;
//    volatile - запрет на создание переменной в кэше. Процессор всегда обращается к опр. памяти.
   // чтение и запись такой переменной всегда будет атомарной.


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++){
            new SomeThread().start();
        }
        Thread.sleep(3000);
        run = false;
    }

    private  static class SomeThread extends Thread{

        @Override
        public void run() {
            while (run){
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    run = false;
                    e.printStackTrace();
                }
            }
        }
    }

//    коллекции с сихронизацией
//    Vector
//    Hashtable
//    Stack
//    StringBuffer

    // однопоточные коллекции + обертки (декораторы)

//    list<String> list = Collections.synchronizedList(new ArrayList<>());
//      Set <String> set = Collections.synchronizedSet(new HashSet<>());
//    Map<String> map = Collections.synchronizedMap(new HashMap<>());


//    Многопоточные коллекции
//    java.util.concurrent. - java 1.5


    // TimeUnit unit класс для работы со временем

//    interface ConcurrentMap
//    чтение и запись всегда будет атомарными
//            чтение не требует блокировнки
//            запись может происходить без блокировки

//    putIfAbsent(key, val);
//        remove(key, val);
//    replace(key, oldValue, newValue);




    // реализации
    // ConcurrentHashMap - блокировка на уровне сегментов
    // ConcurrentSkipListMap - (SkipList алгоритм)
//    ConcurrentSkipListSet

    // интерфейс CopyOnWriteList  много читающих. мало писателей
    // CopyOnWriteList
    // CopyOnWriteArraySet


    // интерфейс - BlockingQueue - блокирующие очереди
    // интерфейс - BlockingDeque -  направленые блокирующие очереди

//    вставка:
//    add(o); ошибка если некуда
//    offer(o); чтение
//    put (o); добавит, когда появится место


//  удаление
//remove (); исключение если нечего удалять
//poll();
//take(); - блокировка потока

//    ArrayBlockingQueue (размер фиксирован) при создании всегда должны пепердать размер
 //   LinkedBlockingQueue() Integer.MAX_VALUE можно не указывать тогда он будет макс значение Интеджера
//   SynchronousQueue каждая операция добавление будет ждать операции удаления и наоборот В ней всегда записан только один элемент






}
