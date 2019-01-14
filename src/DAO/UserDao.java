package DAO;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static DAO.Main.sqlUsers;

public class UserDao extends MyConnection implements Dao<User> {

    public UserDao() throws SQLException {
        getStatment().executeUpdate(sqlUsers);
    }

    @Override
    public void add(User user) {
        try {
            getPStatment(insertU).setInt(1,user.getId());
            getPStatment(insertU).setString(2,user.getName());
            connectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
    public void delete(int id) {
        try {
            getPStatment(delete).setInt(1,id);
            connectionClose();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

//    @Override
//    public void update(int i, String s) {
//
//    }
//
//    @Override
//    public User[] getAll() {
//
//        return new User[];
//    }
//
//    @Override
//    public User getById(int i) {
//        return null;
//    }
}
