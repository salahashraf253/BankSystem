package com.example.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BalanceInquiryController implements Initializable {
    @FXML
    private TextField balance_txt;

    @FXML
    private TextField type_txt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Read from database type and balance of account
        type_txt.setText("Saving Account");
        balance_txt.setText("1234");
    }
}
