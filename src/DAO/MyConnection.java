package DAO;

import org.sqlite.JDBC;

import java.sql.*;

import static DAO.Dao.sql;

public abstract class MyConnection {
    public Connection getConnection() throws SQLException {
    DriverManager.registerDriver(new JDBC());
    Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson2.db");
        return connection;
    }

    public Statement getStatment() throws SQLException {
        Statement statement = getConnection().createStatement();
        return statement;
    }

    public PreparedStatement getPStatment(String sqlText) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlText);
        return preparedStatement;
    }
    public void connectionClose() throws SQLException {
        getConnection().close();
    }

}
