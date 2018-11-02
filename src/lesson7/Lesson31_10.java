package lesson7;

public class Lesson31_10 {
    // _____________________________Book
    // методы Object
    // toString()
    // clone() - возвращает копию объекта
    // getClass() - ссылка на класс объекта
    // finalize() - уничтожение сборкой мусора
    // wait() | notify () | notifyAll() - для многопоточности
    // equals() - сравнение объектов по умолчанию как ==
    // hashCode() - возвращает hashCode объекта

    public static void main(String[] args) {
        Book book1 = new Book("Война","Тол");
        book1.setPages(1000);

        Book book2 = new Book("Война","Тол");
        book2.setPages(1000);
        System.out.println(book1.equals(book2));

        System.out.println(Book.getStatic());
        book1.sellBook();
        book1.sellBook();
        book1.sellBook();
        book1.sellBook();
        book1.sellBook();
        System.out.println(Book.getStatic());

        book2.sellBook();
        System.out.println(Book.getStatic());


        // ------------Вложенные классы


    }
}
