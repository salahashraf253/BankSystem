package com.example.banksystem;

import com.example.NotificationsObserver.EmailNotification;
import com.example.UserFactory.FactoryUser;
import com.example.UserFactory.User;
import com.example.dataBase.DataBaseMapping;
import com.example.dataBase.Functions.DataBaseReader;
import com.example.dataBase.Functions.EncrpytString;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static User validateLogin(String userID, String password) throws SQLException {
        DataBaseReader dataBaseReader= new DataBaseReader();
        String query="select * from user where user_id='" + EncrpytString.getEncrpytedString(userID)
                + "' and password='" + EncrpytString.getEncrpytedString(password)+"';";
        ResultSet resultSet=dataBaseReader.read(query);
        User user= DataBaseMapping.getUser(resultSet);
        dataBaseReader.closeConnection();
        return user;
    }
}
