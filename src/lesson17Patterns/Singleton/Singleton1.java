package lesson17Patterns.Singleton;

public class Singleton1 {// Шаблон Одиночка
    // запретитть создание объектов вне классов
    private static Singleton1 instance;
    private Singleton1(){  }
    // создние объекта по требованию
    public static Singleton1 getInstance(){
        if (instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

}
