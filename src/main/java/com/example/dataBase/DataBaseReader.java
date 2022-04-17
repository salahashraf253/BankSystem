package com.example.dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseReader extends DataBase{

    public  ResultSet read(String query) throws SQLException {
        Connection connection= getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet =statement.executeQuery(query);
        return resultSet;
    }
}
