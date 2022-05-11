package com.example.GUI;

import com.example.UserFactory.Client;
import com.example.banksystem.Account.Account;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
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
    private Client c= (Client) LayoutController.user;
    @FXML
    public void TransferMoney() throws SQLException {
        int toAccount=Integer.parseInt( to_txt.getText());
        float amount= Integer.parseInt( Amount_txt.getText());
        System.out.println("To account: "+toAccount);
        System.out.println("Amount: "+amount);
        // put this Amount in Account where Account number=toAccount
        Account account=c.getAccount();
        if(account.canTransferMoney(amount)){
            account.transferMoney(toAccount,amount);
            account.updateBalance();
        }
        else System.out.println("Can not transfer money");
    }
}
