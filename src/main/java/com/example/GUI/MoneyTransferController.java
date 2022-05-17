package com.example.GUI;

import com.example.Generator.Generator;
import com.example.Generator.IdGenerator;
import com.example.NotificationsObserver.DesktopNotificationBuilder;
import com.example.UserFactory.Client;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import tray.notification.NotificationType;

import java.net.URL;
import java.sql.Date;
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
//         account number of user from database put it in setText
        Client c= (Client) LayoutController.user;
        from_txt.setText(Integer.toString(c.getAccount().getAccount_no()));
    }
    private Client client = (Client) LayoutController.user;
    @FXML
    public void TransferMoney() throws SQLException {
        int toAccount=Integer.parseInt( to_txt.getText());
        float amount= Integer.parseInt( Amount_txt.getText());
        System.out.println("To account: "+toAccount);
        System.out.println("Amount: "+amount);
        // put this Amount in Account where Account number=toAccount
        Account account= client.getAccount();
        if(account.canTransferMoney(amount)){
            account.transferMoney(toAccount,amount);
            account.updateBalance();
            Date date=(new java.sql.Date(new java.util.Date().getTime()));
            IdGenerator idGenerator=new IdGenerator();
            int transactionId= (idGenerator.generate(Generator.generator.transaction_id));
            client.setTransaction(new Transaction(client.getUserId(),transactionId,amount,date,"Transferring to account number: "+toAccount));
            client.addTransaction();
            client.notifyUser("ASU Bank","you have transferred "+amount+" to account number: "+toAccount);
        }
        else {
            DesktopNotificationBuilder.notifyUser("Sorry, your balance is not enough", NotificationType.ERROR);
        }
    }
}
