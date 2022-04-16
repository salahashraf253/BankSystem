package com.example.banksystem;


import com.example.dataBase.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws SQLException {
        welcomeText.setText("Welcome to JavaFX Application!");

        //testing the database connection
        Connection connection=DataBase.getConnection();

        Statement statement=connection.createStatement();

        ResultSet resultSet =statement.executeQuery("select * from user");

        while (resultSet.next()){
            System.out.println(resultSet.getString("iduser"));
        }
        DataBase.closeConnection();
    }
}