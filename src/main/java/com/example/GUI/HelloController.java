package com.example.GUI;


import com.example.dataBase.*;
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
        DataBaseReader dataBaseReader=new DataBaseReader();
        ResultSet resultSet =dataBaseReader.read("select * from user");
        while (resultSet.next()){
            System.out.println(resultSet.getString("iduser"));
        }
        dataBaseReader.closeConnection();
    }
}