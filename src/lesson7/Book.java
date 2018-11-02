package lesson7;

import java.util.Objects;
import java.util.Random;

public class Book {
    String title;
    String author;
    int pages;
    public static int soldBook; // для всех объектов это одна и та же переменная. Это переменная класса, а не объекта.
    static { // выполняется один раз при первом вызове объекта класса.
        soldBook = -(new Random().nextInt(100));
    }
    public void sellBook(){
        soldBook++;
    }
    public static String getStatic(){
        return "Book sold" + soldBook;
    }
    // сатическими могут быть только вложенные классы. Они могут обращаться только к статическим методам и переменным



    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public int hashCode() { // при переопределении equals() необходимо переопределять hashCode()
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() == this.getClass()) {
            Book book = (Book) obj;
            return pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author);
        }
        else return false;
    }


    static final String CONST = "String"; // переменные которые изменить нельзя
    // им либо сразу присвоить значение, либо в конструкторе. Они пишуться капсом и нижним подчеркиванием
    // можно сделать ее статической и присвоить ей значение в статическом блоке
    // метод тоже может быть final
    // final class не может иметь наследников
    // final аргументы в методе доступны только для чтения. Их изменить не сможете



}
