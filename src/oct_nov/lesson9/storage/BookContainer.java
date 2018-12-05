package oct_nov.lesson9.storage;

import oct_nov.lesson9.classes.Book;

public class BookContainer<T extends Book> {
    private T book;
    public BookContainer (T book){
        this.book.getName();
    }
    public String getBookTitle (){
        return this.book.getName();
    }

    public static void main (String[] args){
        Book tails = new Book("Сказки", 30);
        BookContainer<Book> container = new BookContainer<>(tails);
        System.out.println(container.getBookTitle());

    }
}
