package com.example.banksystem;

import com.example.UserFactory.User;
import com.example.dataBase.DataBaseMapping;
import com.example.dataBase.Functions.DataBaseReader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static User validateLogin(String userID, String password) throws SQLException {
        DataBaseReader dataBaseReader= new DataBaseReader();
        String query="select * from user where user_id='" + userID + "' and password='" + password+"';";
        ResultSet resultSet=dataBaseReader.read(query);
        User user= DataBaseMapping.getUser(resultSet);
        return user;
    }
}
