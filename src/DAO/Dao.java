package DAO;

import java.sql.SQLException;
import java.util.List;

public interface Dao <T>{

    void add(T t) throws SQLException;
    void delete(int id) throws SQLException;
    void update(int id, T t) throws SQLException;
    T getById(int id) throws SQLException;
    List<T> getAll() throws SQLException;


    String sql = "CREATE TABLE IF NOT EXISTS Example (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, firstColumn TEXT NOT NULL, secondColumn INTEGER NOT NULL);";
    String insertU = "INSERT INTO User (id, login) VALUES (?, ?);";
    String insertA = "INSERT INTO Article (id, title) VALUES (?, ?);";
    String getAll = "SELECT * FROM User;";
    String getById = "SELECT * FROM User WHERE id= ?;";
    String updateU = "UPDATE User SET id=?, login = ? WHERE id=?;";
    String updateA = "UPDATE Article SET id=?, login = ? WHERE id=?;";
    String deleteU = "DELETE FROM User WHERE id=?;";
    String deleteA = "DELETE FROM Article WHERE id=?;";


}
