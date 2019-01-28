package DAO;

import org.sqlite.JDBC;

import java.sql.*;

public abstract class MyConnection<T> implements Dao<T> {

    protected Connection connection;


    public void getConnection() throws SQLException {
    DriverManager.registerDriver(new JDBC());
    connection = DriverManager.getConnection("jdbc:sqlite:lesson3.db");
    }


    public PreparedStatement getPStatment(String sqlText) throws SQLException {
        if (connection.isClosed()) getConnection();
        return connection.prepareStatement(sqlText);
    }


    public void connectionClose() throws SQLException {
        connection.close();
    }
    protected String strParam(String param){
        return '\'' + param + '\'';
    }

    protected String intParam(int param){
        return String.valueOf(param);
    }

    protected void sqlExecute(String sqlString, String ... param) throws SQLException {
        if (connection.isClosed()) getConnection();
        for (int i = 0; i < param.length; i++)
            sqlString = sqlString.replaceFirst("\\?", param[i]);
        getPStatment(sqlString).executeUpdate();
        connectionClose();
    }

    protected ResultSet sqlExecuteResult(String sqlString, String ... param) throws SQLException {
        ResultSet res;
        if (connection.isClosed()) getConnection();
        for (int i = 0; i < param.length; i++)
            sqlString = sqlString.replaceFirst("\\?", param[i] );
        res = getPStatment(sqlString).executeQuery();
        return res;
    }



}
