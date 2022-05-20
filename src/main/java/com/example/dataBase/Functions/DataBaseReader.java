package com.example.dataBase.Functions;

import com.example.dataBase.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseReader{
    public ResultSet read(String query) throws SQLException {
        DataBase db=DataBase.getDataBaseInstance();
        Statement statement= db.getConnection().createStatement();
        ResultSet resultSet =statement.executeQuery(query);
        return resultSet;
    }

}
