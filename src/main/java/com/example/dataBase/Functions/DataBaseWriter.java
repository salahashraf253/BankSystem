package com.example.dataBase.Functions;

import com.example.Decorator.EncryptStringProvider;
import com.example.Decorator.PlainStringProvider;
import com.example.Decorator.StringProvider;
import com.example.Decorator.StringProviderDecorator;
import com.example.dataBase.DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseWriter extends DataBase {

    public void write(String query) throws SQLException {
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        try {
            statement.executeUpdate(query);
            System.out.println("DataBase insertion is successfully");
        }
        catch (SQLException sqlException){
            System.out.println("Error in Database writer");
            System.out.println(sqlException.getMessage());
        }
    }

    //Salah: test the database writer with encryption
    public static void main(String []args) throws SQLException {
        String user_id="100100";
        user_id=EncrpytString.getEncrpytedString(user_id);
        DataBaseWriter dataBaseWriter=new DataBaseWriter();
        String firstName="Salah";
        firstName=EncrpytString.getEncrpytedString(firstName);

        System.out.println("Name :"+firstName);
        String ssn="30110211401634";
        ssn=EncrpytString.getEncrpytedString(ssn);
        String email="salahashraf924@gmail.com";
        email=EncrpytString.getEncrpytedString(email);
        String password="123456Ab#";
        password=EncrpytString.getEncrpytedString(password);

        String lastName="Ashraf";
        lastName=EncrpytString.getEncrpytedString(lastName);
        String salary="5000";
        salary=EncrpytString.getEncrpytedString(salary);

        String phone="01102527521";
        phone=EncrpytString.getEncrpytedString(phone);
        Date dob=new Date(2001,10,21);
        String address="Cairo";
        address=EncrpytString.getEncrpytedString(address);
        String status="s";
        status=EncrpytString.getEncrpytedString(status);
        String gender="m";
        gender=EncrpytString.getEncrpytedString(gender);
        String type="c";
        type=EncrpytString.getEncrpytedString(type);
        String query="insert into user" +
                " (user_id,ssn,email,password,firstName,lastName, " +
                "salary, phone,dob,address,status,gender,type)"+
                "VALUES(" +
                "'" + user_id + "'," +
                        "'" + ssn + "'," +
                        "'" + email + "'," +
                        "'" + password + "'," +
                        "'" + firstName + "'," +
                        "'" + lastName + "'," +
                        "'" + salary + "'," +
                        "'"+phone+"',"+
                        "'"+dob+"',"+
                        "'"+address+"',"+
                        "'"+status+"',"+
                         "'"+gender+"',"+
                          "'"+type+"'"+
                              ")";
        dataBaseWriter.write(query);
    }
}
