package com.example.GUI;

import com.example.Generator.Generator;
import com.example.Generator.IdGenerator;
import com.example.UserFactory.Client;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Transaction;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

import static com.example.GUI.LayoutController.user;

public class HomeController implements Initializable {
    @FXML
    public  Label name_lbl, account_num_lbl ,account_type_lbl,balance_lbl;
    @FXML
    public Label rem_balance_lbl;
    private Client client=(Client) user;;
    @FXML
    private TextField withdraw_amount_txt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            System.out.println("Name: "+ user.getFirstname());
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
        if(withdraw_amount_txt.getText().length()==0){
            System.out.println("Please enter a valid amount");
            return;
        }
        float amount=Float.parseFloat(withdraw_amount_txt.getText());
        Account account= client.getAccount();
        account.setAccount_no(client.getUserId());
        if(account.canWithdraw(amount)){
            account.withdraw(amount);
            updateRemainingBalanceLabel();
            try {
                account.updateBalance();
                IdGenerator idGenerator=new IdGenerator();
                int transactionId= (idGenerator.generate(Generator.generator.transaction_id));
                Date date=(new java.sql.Date(new java.util.Date().getTime()));
                client.setTransaction(new Transaction(client.getUserId(),transactionId,amount,date,"withdraw"));
                client.addTransaction();
                client.notifyUser("ASU Bank","you have withdrawn "+amount);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Sorry, Your balance is not enough");
    }
    private void updateRemainingBalanceLabel(){
        rem_balance_lbl.setText(Float.toString(client.getAccount().getBalance()));
    }
}
