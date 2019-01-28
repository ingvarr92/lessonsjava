package xml;

public class Article {
    String id;
    String author;
    String title;
    String genre;
    String publish_date;
    String text;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", publishDate='" + publish_date + '\'' +
                ", text='" + text + '\'' +
                '}' + "\n";
    }
}
