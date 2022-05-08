package com.example.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private Label acc_type_lbl, balance_lbl;
    @FXML
    private TextField title_txt, name_txt, gender_txt, dob_txt, id_txt, marital_txt, occupation_txt, income_txt;
    @FXML
    private TextField address_txt, email_txt, phone_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserData();
    }
    void loadUserData(){
        //load all user data from Database and show it
    }

}
