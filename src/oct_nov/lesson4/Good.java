package oct_nov.lesson4;

public class Good {
    private String title;
    private int price;
//Constructor их может быть несколько. В него можно добавлять все что угодно.

    public Good(){}// пустой конструктор (по умолчанию)

    public Good(String title, int price) {
        this.title = title;
        this.price = price;
    }
// Setter Getter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
