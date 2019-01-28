package DAO;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DAO.Main.sqlUsers;

public class UserDao extends MyConnection<User> implements Dao<User> {

    public UserDao() throws SQLException {
      getConnection();
      sqlExecute(sqlUsers);
    }

    @Override
    public void add(User user) throws SQLException {
        sqlExecute(insertU, strParam(user.getName()));
    }

        @Override
    public void delete(int id) throws SQLException {
            sqlExecute(deleteU, intParam(id));

        }

    @Override
    public void update(int i, User user) throws SQLException{
        sqlExecute(updateU, intParam(i), strParam(user.getName()), intParam(user.getId()));
    }

    @Override
    public List<User> getAll()  throws SQLException {
        ResultSet resultSet = sqlExecuteResult(getAll);
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            users.add(new User(resultSet.getString("login")));
        }
        connectionClose();
        return users;
    }

    @Override
    public User getById(int i) throws SQLException {
        ResultSet resultSet = sqlExecuteResult(getById, intParam(i));
        resultSet.next();
        User user = new User(resultSet.getString("login"));
        connectionClose();
        return user;

    }
}
