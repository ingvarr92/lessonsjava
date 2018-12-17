package lesson23.homeWork.bank;

public class User {
    private static int idCount = 0;
    private int userId;
    private String eMail;

    public User(String eMail) {
        this.eMail = eMail;
        this.userId = idCount++;

    }

    public int getUserId() {
        return userId;
    }

    public String geteMail() {
        return eMail;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
