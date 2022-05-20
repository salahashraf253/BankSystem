package com.example.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton pattern is applied in this class
public class DataBase {
    private static final String dataBaseSchema="bank_data_base";
    private static final String url="jdbc:mysql://localhost:3306/" + dataBaseSchema;
    private static final String user="root";
    private static final String password="1234";
    private static Connection connection;
    private static DataBase dataBaseConnection;

    static {
        try {
            dataBaseConnection = new DataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DataBase() throws SQLException {
        dataBaseConnection.openConnection();
    }
    private static void openConnection() throws SQLException {
        connection=DriverManager.getConnection(url,user,password);
        System.out.println("Connections is opened");
    }

    public static DataBase getDataBaseInstance() throws SQLException {
        return dataBaseConnection;
    }
    public static Connection getConnection(){
        return dataBaseConnection.connection;
    }
//
}
