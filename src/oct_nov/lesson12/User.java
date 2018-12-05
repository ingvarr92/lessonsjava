package oct_nov.lesson12;

public class User implements Comparable<User>{ // имплементация интерфейса сравнения
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "id: " + id + " name: " + name;
    }


    @Override
    public int compareTo(User o) { // метод сравнения
        return name.length() - o.name.length();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
