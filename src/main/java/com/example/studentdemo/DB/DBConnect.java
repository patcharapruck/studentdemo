package com.example.studentdemo.DB;

import java.sql.*;

public class DBConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public  Connection connect(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL,USER,PASSWORD);
            if (!this.connection.isClosed()){

            }
            else {

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.connection;
    }

    public void Close() throws SQLException {
        this.connection.close();
    }

}
