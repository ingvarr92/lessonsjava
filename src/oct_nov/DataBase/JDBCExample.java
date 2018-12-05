package oct_nov.DataBase;

import org.sqlite.JDBC;

import java.sql.*;

public class JDBCExample {
    // создать таблицу
    public static void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Example (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, firstColumn TEXT NOT NULL, secondColumn INTEGER NOT NULL);";
        DriverManager.registerDriver(new JDBC());
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);// передаем sql запрос
            System.out.println(row);
        }
    }

    // вставить данные в таблицу
    public static void insertIntoTable()  throws SQLException {
        String sql = "INSERT INTO Example (firstColumn, secondColumn) VALUES ('Value1', 123);";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);// передаем sql запрос
            System.out.println(row);
        }

    }



    // получить данные из таблицы

    public static void selectData() throws SQLException{
        String sql = "SELECT * FROM example WHERE id < 3;"; // работают любые условия
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson.db")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);// передаем sql запрос в него попадут данные из таблички
            while (resultSet.next()){
                String str = resultSet.getString("firstColumn");
                int i = resultSet.getInt("id");
                System.out.println("str = "+ str);
                System.out.println("id = "+ i);
            }


        }

    }


    public static void main(String[] args) {
        try {
          //  JDBCExample.createTable();
            //insertIntoTable();
            selectData();

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }



}
