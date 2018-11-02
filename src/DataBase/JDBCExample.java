package DataBase;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
    // создать таблицу
    public static void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Example (id PRIMARY KEY AUTOINCREMENT NOT NULL, firstColumn TEXT NOT NULL, secondColumn INTEGER NOT NULL);";
        //
        DriverManager.registerDriver(new JDBC());
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson.db")) {
            Statement statement = connection.createStatement();
            // statement.
        }
    }
    // вставить данные в таблицу
    // получить данные из таблицы




}
