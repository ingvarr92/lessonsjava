package lesson17Patterns.Singleton;

public class Singleton2 {
    // объект создается сразу при инициализации метода
    private static final Singleton2 INSTANCE = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return INSTANCE;
    }

}
