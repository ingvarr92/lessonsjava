package DAO;


import org.sqlite.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

    final static String sqlUsers = "CREATE TABLE IF NOT EXISTS User (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, login TEXT NOT NULL);";
    final static String sqlArticles = "CREATE TABLE IF NOT EXISTS Article (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT NOT NULL, idUser INTEGER NOT NULL);";


    public static void main(String[] args) {

       try {
           UserDao userDao = new UserDao();
           ArticleDao articleDao = new ArticleDao();
           userDao.add(new User("Igor"));
           userDao.add(new User("Ivan"));
           articleDao.add(new Article("messageOne", 2));
           articleDao.add(new Article("messageTwe", 3));
           articleDao.add(new Article("messageThree", 2));
           System.out.println(userDao.getById(2));
           System.out.println("----------------");
           List<User> users = userDao.getAll();
           for (User user : users) {
               System.out.println(user);
           }

           System.out.println("----------------");
           List<Article> articles = articleDao.getAll();
           for (Article article : articles) {
               System.out.println(article);

           }
       }
       catch (SQLException e){
           System.out.println(e);
       }

    }
}
