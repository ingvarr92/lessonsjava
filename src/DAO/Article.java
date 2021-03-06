package DAO;

public class Article {
    private static int count = 0;
    private int id;
    private String title;
    private int idUser;

    public Article(String title, int idUser) {
        count++;
        this.id = count;
        this.title = title;
        this.idUser = idUser;
    }
    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", idUser=" + idUser +
                '}';
    }


}
