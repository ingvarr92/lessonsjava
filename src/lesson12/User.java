package lesson12;

public class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 42 * id * (name != null ? name.hashCode(): 3 );
        return result;
    }
}
