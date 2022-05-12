package com.example.GUI;

import com.example.UserFactory.Client;
import com.example.UserFactory.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.GUI.LayoutController.user;

public class BalanceInquiryController implements Initializable {
    @FXML
    private Label acc_type_lbl;
    @FXML
    private Label balance_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Read from database type and balance of account
        try {
            User u= (Client) user;
            acc_type_lbl.setText(((Client) u).getAccount().getAccountType());
            String balance= String.valueOf(((Client) u).getAccount().getBalance());
            balance_lbl.setText(balance);
        }
        catch (Exception e){
            System.out.println("Error in Balance Inquiry");
            System.out.println(e.getMessage());
        }
    }
}
