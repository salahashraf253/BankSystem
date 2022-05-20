package com.example.dataBase.Functions;

import com.example.dataBase.DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUpdater{

    public void update(String query) throws SQLException {
        DataBase db=DataBase.getDataBaseInstance();
        Statement statement= db.getConnection().createStatement();
        try {
            statement.executeUpdate(query);
            System.out.println("Database updated successfully");
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }

}
