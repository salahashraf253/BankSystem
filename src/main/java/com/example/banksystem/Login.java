package com.example.banksystem;

import com.example.UserFactory.FactoryUser;
import com.example.UserFactory.User;
import com.example.dataBase.Functions.DataBaseReader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public void validateLogin(String userID, String password) throws SQLException {
        DataBaseReader dataBaseReader= new DataBaseReader();
        String query="select * from user where id='" + userID+ "' and password='" + password+"'";
        ResultSet resultSet=dataBaseReader.read(query);
        if (resultSet.next()){
            String type=resultSet.getString("type");
            FactoryUser factoryUser=new FactoryUser();
            User user=factoryUser.getUserType(type);

            //set the user attributes from the database
            //password
            user.setPassword(password);
            //user id
            user.setUserId(userID);
            // Email
            user.setEmail(resultSet.getString("email"));
            // Salary
            user.setSalary(resultSet.getInt("salary"));
            // First Name
            user.setFirstName(resultSet.getString("firstName"));
            // Last Name
            user.setLastName(resultSet.getString("lastName"));
            // Phone Number
            user.setPhoneNumber(resultSet.getString("phoneNumber"));
            System.out.println(type);
            System.out.println("Done");
        }
        else System.out.println("Invalid user or password");
        dataBaseReader.closeConnection();
    }

    public static void main(String[]args) throws SQLException {
        Login login=new Login();
        login.validateLogin("12","1233123123");
    }

}
