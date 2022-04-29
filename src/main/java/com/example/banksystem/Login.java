package com.example.banksystem;

import com.example.NotificationsObserver.EmailNotification;
import com.example.UserFactory.FactoryUser;
import com.example.UserFactory.User;
import com.example.dataBase.Functions.DataBaseReader;
import com.example.dataBase.Functions.DecryptString;
import com.example.dataBase.Functions.EncrpytString;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public User validateLogin(String userID, String password) throws SQLException {
        DataBaseReader dataBaseReader= new DataBaseReader();
        String query="select * from user where user_id='" + EncrpytString.getEncrpytedString(userID)
                + "' and password='" + EncrpytString.getEncrpytedString(password)+"';";
        ResultSet resultSet=dataBaseReader.read(query);
        if (resultSet.next()){
            System.out.println("Successful login ");
            String type=DecryptString.getDecrptString(resultSet.getString("type"));
            FactoryUser factoryUser=new FactoryUser();
            User user=factoryUser.getUserType(type);

//            set the user attributes from the database
            user.setPassword(password);
            //user id
            user.setUserId(Integer.parseInt(DecryptString.getDecrptString(resultSet.getString("user_id"))));
            // Email
            user.setEmail(DecryptString.getDecrptString(resultSet.getString("email")));
            // Salary
            user.setSalary(Integer.parseInt(DecryptString.getDecrptString(resultSet.getString("salary"))));
            // First Name
            user.setFirstname(DecryptString.getDecrptString(resultSet.getString("firstName")));
            // Last Name
            user.setLastname(DecryptString.getDecrptString(resultSet.getString("lastName")));
            // Phone Number
            user.setPhonenumber(DecryptString.getDecrptString(resultSet.getString("phone")));
            System.out.println("First Name: "+user.getFirstname());
            System.out.println("Email: "+user.getEmail());
            System.out.println("Type client or staff: "+type);
            System.out.println("Done");
            return user;
        }
        else System.out.println("Invalid user or password");
        dataBaseReader.closeConnection();
        return null;
    }

    public static void main(String[]args) throws SQLException {
        Login login=new Login();
        User user=login.validateLogin("12","1233123123");

    }

}
