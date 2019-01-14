package DAO;

public class User {
    private static int count = 0;
    private int id;
    private String login;

    public User(String name) {
        count++;
        this.id = count;
        this.login = name;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return login;
    }

    public void setName(String name) {
        this.login = name;
    }
}
