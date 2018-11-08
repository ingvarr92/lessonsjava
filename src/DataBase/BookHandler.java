package DataBase;

import org.sqlite.JDBC;

import java.sql.*;

public class BookHandler {

    public static void createTable() throws SQLException {

//        String sql = "CREATE TABLE IF NOT EXISTS Book2 (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT NOT NULL, pages INTEGER NOT NULL);";
//        DriverManager.registerDriver(new JDBC());
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson.db")) {
//            Statement statement = connection.createStatement();
//            int row = statement.executeUpdate(sql);// передаем sql запрос
//            System.out.println(row);
        }
  //  }

    public static void insertIntoTable(Lesson8Book book) throws SQLException {
        String sql = "INSERT INTO Book (title, pages) VALUES (?, ?);";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:book.db")) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getPages());

            int row = statement.executeUpdate();// передаем sql запрос
            System.out.println(row);
        }

    }


    public static Lesson8Book selectData(int id) throws SQLException {
        String sql = "SELECT * FROM book WHERE id = ?;"; // работают любые условия
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:book.db")) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();// передаем sql запрос в него попадут данные из таблички

            Lesson8Book [] books = new Lesson8Book[3];
            for (int i = 0; resultSet.next();i++){
                Lesson8Book book = new Lesson8Book();
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
            }
            Lesson8Book book = new Lesson8Book();
            while (resultSet.next()) {
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
//                String setTitle = resultSet.getString("title");
//                int setPages = resultSet.getInt("pages");
//                System.out.println("title = " + setTitle);
//                System.out.println("pages = " + setPages);
            }
            return book;
        }
    }

    public static void main(String[] args) {

//        Lesson8Book book = new Lesson8Book("Война и Мир", 5600);
//        Lesson8Book book1 = new Lesson8Book("Война", 5600);
//        Lesson8Book book2 = new Lesson8Book("Мир", 5600);
//        Lesson8Book book3 = new Lesson8Book("Война и М", 5600);
        try {
            // BookHandler.createTable();

//           insertIntoTable(book);
//           insertIntoTable(book2);
//           insertIntoTable(book3);
//           insertIntoTable(book1);
            System.out.println(BookHandler.selectData(6));



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}