package com.example.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton pattern is applied in this class
public abstract class DataBase {
    private static final String dataBaseSchema="banksystem";
    private static final String url="jdbc:mysql://localhost:3306/" + dataBaseSchema;
    private static final String user="root";
    private static final String password="1234";
    private static Connection connection;

    private static void openConnection() throws SQLException {
        connection=DriverManager.getConnection(url,user,password);
        System.out.println("Connections is opened");
    }

    public static Connection getConnection() throws SQLException {
        if(connection==null||connection.isClosed()) {
            System.out.println("The database connection is closed");
            try {
                System.out.println("Try opening the connection.......");
                openConnection();
            }
            catch (SQLException sqlException) {
                System.out.println("Error in Connecting Data Base");
                System.out.println(sqlException.getMessage());
            }
        }
        else
            System.out.println("The connection is already opened");
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
