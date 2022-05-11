package com.example.GUI;

import com.example.UserFactory.Client;
import com.example.banksystem.Account.Account;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    public  Label name_lbl, account_num_lbl ,account_type_lbl,balance_lbl;
    @FXML
    public Label rem_balance_lbl;

    private Client client=(Client)LayoutController.user;;

    @FXML
    private TextField withdraw_amount_txt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            System.out.println("Name: "+LayoutController.user.getFirstname());
//            name_lbl.setText(LayoutController.user.getFirstname());
            Platform.runLater(() -> {
                name_lbl.setText(client.getFirstname());
                String accountNumber= String.valueOf(client.getAccount().getAccount_no());
                account_num_lbl.setText(accountNumber);
                account_type_lbl.setText(client.getAccount().getAccountType());
                balance_lbl.setText(Integer.toString(client.getSalary()));
                rem_balance_lbl.setText(Float.toString(client.getAccount().getBalance()));
                updateRemainingBalanceLabel();
            });
        }
        catch (Exception e){
            System.out.println("Error in home controller");
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void withdrawMoney() throws SQLException {
        float amount=Float.parseFloat(withdraw_amount_txt.getText());
        Account account= client.getAccount();
        account.setAccount_no(client.getUserId());
        if(account.canWithdraw(amount)){
            account.withdraw(amount);
            account.updateBalance(amount);
            updateRemainingBalanceLabel();
        }
        else System.out.println("Sorry, Your balance is not enough");
    }
    private void updateRemainingBalanceLabel(){
        rem_balance_lbl.setText(Float.toString(client.getAccount().getBalance()));

    }

}
