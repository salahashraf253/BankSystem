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

    public User validateLogin(String userID, String password) throws SQLException {
        DataBaseReader dataBaseReader= new DataBaseReader();
        String query="select * from user where user_id='" + EncrpytString.getEncrpytedString(userID)
                + "' and password='" + EncrpytString.getEncrpytedString(password)+"';";
        ResultSet resultSet=dataBaseReader.read(query);
        User user= DataBaseMapping.getUser(resultSet);
        if(user==null){
            //Invalid user id or password
            return null;
        }
        System.out.println("Email: "+user.getEmail());
        dataBaseReader.closeConnection();
        return user;
    }

    public static void main(String[]args) throws SQLException {
        Login login=new Login();
        User user=login.validateLogin("12","1233123123");

    }

}
