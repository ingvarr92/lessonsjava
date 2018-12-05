package oct_nov.lesson9;

import oct_nov.lesson9.classes.Book;
import oct_nov.lesson9.classes.Car;
import oct_nov.lesson9.classes.ChildBook;
import oct_nov.lesson9.storage.Storage;

public class Main {

    public static void main(String[] args) {
        Book tails = new Book("Сказки", 500);
        Book flowers = new Book("Цветы", 600);

        Car car = new Car("green", 1000);

        Storage<Book> bookStorage = new Storage(); // указали тип хранимых данных
        bookStorage.add(tails);
        bookStorage.add(flowers);
        //bookStorage.add(car);

        // ClassCastException возникает на моменте исполнения
        Book bookFromStorage = bookStorage.get(2); // больше не надо приводить типы
        System.out.println(bookFromStorage);

        Storage <ChildBook> childBookStorage = new Storage<>();
        ChildBook bears = new ChildBook("Маша и Медведи",200, "pics");
        ChildBook coloring = new ChildBook("Coloring",201, "pics");

        childBookStorage.add(bears);

//        Book firstBook = getFirstBook(bookStorage);
//        Book firstBook = getFirstBook(childBookStorage);





    }

//    public static Book getFirstBook (Storage<Book> storage){
//        return storage.get(0);
  //  }

    public static Book getFirstBook(Storage<? extends Book> storage){ // метод может работать с классом Book и с его потомками
        return storage.get(0);
    }

    public static void addToStorage(Storage<? super Book>storage){// что бы добавить в хранилище
        Book book = new Book("book",40);
        storage.add(book);

       Object b = storage.get(0);
    }
    public static void addGet (Storage<?> storage){// добавить только null и получить только Object
        Book book = new Book("F",20);
        storage.add(null);
       Object b = storage.get(0);


    }


}
