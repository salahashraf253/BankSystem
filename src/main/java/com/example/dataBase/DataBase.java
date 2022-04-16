package com.example.dataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataBase {
    private static String dataBaseSchema="banksystem";
    private static String url="jdbc:mysql://localhost:3306/" + dataBaseSchema;
    private static String user="root";
    private static String password="1234";
    private static Connection connection;


    private DataBase(){}

    public static Connection getConnection() throws SQLException {
        if(connection==null||connection.isClosed()) {
            System.out.println("The database connection is closed");
            try {
                connection=DriverManager.getConnection(url,user,password);
            }
            catch (SQLException sqlException){
                System.out.println("Error in Connecting Data Base");
                System.out.println(sqlException.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
