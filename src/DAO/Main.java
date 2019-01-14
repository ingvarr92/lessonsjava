package DAO;


import org.sqlite.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    final  static String sqlUsers = "CREATE TABLE IF NOT EXISTS User (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, login TEXT NOT NULL);";
    final  static String sqlArticles = "CREATE TABLE IF NOT EXISTS Article (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT NOT NULL, idUser INTEGER NOT NULL);";


    public static void main(String[] args) {
        User user = new User("Igor");
        Article article = new Article("My", 1);

       try{
           UserDao userDao = new UserDao();
           ArticleDao articleDao = new ArticleDao();
           userDao.add(user);
           articleDao.add(article);


       }
       catch (Exception e){
           System.out.println(e);
       }

    }
}
