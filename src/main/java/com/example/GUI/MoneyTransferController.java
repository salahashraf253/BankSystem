package com.example.GUI;

import com.example.UserFactory.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MoneyTransferController implements Initializable {
    @FXML
    TextField Amount_txt;
    @FXML
    TextField from_txt;
    @FXML
    TextField to_txt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // account number of user from database put it in setText
        Client c= (Client) LayoutController.user;
        from_txt.setText(Integer.toString(c.getAccount().getAccount_no()));
    }
    @FXML
    public void TransferMoney(){
        int toAccount=Integer.parseInt( to_txt.getText());
        double amount= Integer.parseInt( Amount_txt.getText());
        // put this Amount in Account where Account number=toAccount

    }
}
