package com.example.GUI;

import com.example.UserFactory.Client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    public  Label name_lbl, account_num_lbl ,account_type_lbl,balance_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            System.out.println("Name: "+LayoutController.user.getFirstname());
//            name_lbl.setText(LayoutController.user.getFirstname());
            Platform.runLater(() -> {
                name_lbl.setText(LayoutController.user.getFirstname());
                Client c=(Client)LayoutController.user;
                String accountNumber= String.valueOf(c.getAccount().getAccount_no());
                account_num_lbl.setText(accountNumber);
                account_type_lbl.setText(c.getAccount().getAccountType());
                balance_lbl.setText(Integer.toString(c.getSalary()));
            });
        }
        catch (Exception e){
            System.out.println("Error in home controller");
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void withdrawMoney() {
    }

}
