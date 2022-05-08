package com.example.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class OpenAccountController implements Initializable {

    @FXML
    AnchorPane open_account_pane;
    @FXML
    ComboBox<String> title_cmb;
    @FXML
    ComboBox<String> occupation_cmb;
    @FXML
    ComboBox<String> acc_type_cmb;
    @FXML
    CheckBox single_checkbox, married_checkbox, divorced_checkbox, widowed_checkbox;

    PageLoader pageLoader = new PageLoader();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title_cmb.getItems().addAll("Mr.", "Mrs.", "Ms.");
        occupation_cmb.getItems().addAll("Accountant", "Actor/ Actress", "Architect", "Baker", "Businessman", "Carpenter",
                "Computer Programmer", "Chef", "Dentist", "Doctor", "Electrician", "Engineer", "Factory Worker", "Farmer",
                "Fireman", "Flight Attendant", "Judge", "Lawyer", "Musician", "Nurse", "Photographer", "Pilot", "Police Officer",
                "Self Employed", "Scientist", "Student", "Taxi Driver", "Teacher", "Worker");
        acc_type_cmb.getItems().addAll("Checking", "Saving", " MoneyMarket", "Certificate Deposit");
    }
    void clearAllCheckBox(){
        single_checkbox.setSelected(false);
        married_checkbox.setSelected(false);
        divorced_checkbox.setSelected(false);
        widowed_checkbox.setSelected(false);
    }
    @FXML
    void singleChkHandler(){
        clearAllCheckBox();
        single_checkbox.setSelected(true);
    }
    @FXML
    void marriedChkHandler(){
        clearAllCheckBox();
        married_checkbox.setSelected(true);
    }
    @FXML
    void divorcedChkHandler(){
        clearAllCheckBox();
        divorced_checkbox.setSelected(true);
    }
    @FXML
    void widowedChkHandler(){
        clearAllCheckBox();
        widowed_checkbox.setSelected(true);
    }

    String getSelectedChk(){
        if(single_checkbox.isSelected())
            return single_checkbox.getText();
        else if(married_checkbox.isSelected())
            return married_checkbox.getText();
        else if(divorced_checkbox.isSelected())
            return divorced_checkbox.getText();
        else if(widowed_checkbox.isSelected())
            return widowed_checkbox.getText();
        return null;
    }

    @FXML
    void closeWindow() {
        open_account_pane.setVisible(false);
    }

    @FXML
    void submit(){
        pageLoader.loadPage("/com/example/banksystem/AccountConfirmation.fxml","EDB",false, false);
        open_account_pane.setVisible(false);
    }
}
