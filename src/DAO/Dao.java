package DAO;

public interface Dao <T>{

    void add(T t);
    void delete(int i);
   // void update(int i, String s);
  //  T[] getAll();
  //  T getById(int i);


    String sql = "CREATE TABLE IF NOT EXISTS Example (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, firstColumn TEXT NOT NULL, secondColumn INTEGER NOT NULL);";
    String insertU = "INSERT INTO User (id, login) VALUES (?, ?);";
    String insertA = "INSERT INTO Article (id, title) VALUES (?, ?);";
    String getAll = "SELECT * FROM User;";
    String getById = "SELECT * FROM User WHERE id= ?;";
    String update = "UPDATE User SET id=?, login = ? WHERE id=?;";
    String delete = "DELETE FROM User WHERE id=?;";


}
