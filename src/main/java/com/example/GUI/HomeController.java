package com.example.GUI;

import com.example.Generator.Generator;
import com.example.Generator.IdGenerator;
import com.example.NotificationsObserver.DesktopNotificationBuilder;
import com.example.UserFactory.Client;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Transaction;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tray.notification.NotificationType;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.GUI.LayoutController.user;

public class HomeController implements Initializable {
    @FXML
    private AnchorPane deposit_pane, withdraw_pane;
    @FXML
    public  Label name_lbl, account_num_lbl ,account_type_lbl,balance_lbl;
    @FXML
    public Label rem_balance_lbl, current_balance_lbl;
    @FXML
    private TextField withdraw_amount_txt, deposit_amount_txt;
    @FXML
    private JFXButton deposit_withdraw_btn;
    @FXML
    private Client client=(Client) user;;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            System.out.println("Name: "+ user.getFirstName());
//            name_lbl.setText(LayoutController.user.getFirstname());
            Platform.runLater(() -> {
                name_lbl.setText(client.getFirstName());
                String accountNumber= String.valueOf(client.getAccount().getAccount_no());
                account_num_lbl.setText(accountNumber);
                account_type_lbl.setText(client.getAccount().getAccountType());
                balance_lbl.setText(Float.toString(client.getAccount().getBalance()));
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
    public void deposit_withdraw(){
        if (deposit_withdraw_btn.getText().equalsIgnoreCase("Cash Deposit")) {
            withdraw_pane.setVisible(false);
            deposit_pane.setVisible(true);
            deposit_withdraw_btn.setText("Cash Withdrawal");
        }
        else if (deposit_withdraw_btn.getText().equalsIgnoreCase("Cash Withdrawal")){
            deposit_pane.setVisible(false);
            withdraw_pane.setVisible(true);
            deposit_withdraw_btn.setText("Cash Deposit");
        }
    }
    @FXML
    public void cashDeposit() throws SQLException{
        if(deposit_amount_txt.getText().length()==0){
            DesktopNotificationBuilder.notifyUser("Please enter a valid amount",NotificationType.NOTICE);
            return;
        }
        float amount=Float.parseFloat(deposit_amount_txt.getText());
        Account account= client.getAccount();
        account.setAccount_no(client.getUserId());
        account.deposit(amount);
        updateRemainingBalanceLabel();
        try {
            account.updateBalance();
            IdGenerator idGenerator=new IdGenerator();
            int transactionId= (idGenerator.generate(Generator.generator.transaction_id));
            Date date=(new java.sql.Date(new java.util.Date().getTime()));
            client.setTransaction(new Transaction(client.getUserId(),transactionId,amount,date,"Deposit"));
            client.addTransaction();
            client.notifyUser("ASU Bank","Amount of EGP "+amount+" has been deposited in you account");
        } catch (SQLException e) {
            DesktopNotificationBuilder.notifyUser("Sorry, Deposit operation failed",NotificationType.ERROR);
            e.printStackTrace();
        }
    }
    @FXML
    public void withdrawMoney() throws SQLException {
        if(withdraw_amount_txt.getText().length()==0){
            DesktopNotificationBuilder.notifyUser("Please enter a valid amount",NotificationType.NOTICE);
            return;
        }
        float amount=Float.parseFloat(withdraw_amount_txt.getText());
        Account account= client.getAccount();
        account.setAccount_no(client.getUserId());
        if(account.canWithdraw(amount)){
            account.withdraw(amount);
            System.out.println("with draw");
            updateRemainingBalanceLabel();
            try {
                account.updateBalance();
                IdGenerator idGenerator=new IdGenerator();
                int transactionId= (idGenerator.generate(Generator.generator.transaction_id));
                Date date=(new java.sql.Date(new java.util.Date().getTime()));
                client.setTransaction(new Transaction(client.getUserId(),transactionId,amount,date,"Withdraw"));
                client.addTransaction();
                client.notifyUser("ASU Bank","Amount of EGP "+amount+" has been \ndeducted from your balance");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else DesktopNotificationBuilder.notifyUser("Sorry, Your balance is not sufficient", NotificationType.ERROR);
    }
    public static void delay(long millis) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        new Thread(sleeper).start();
    }
    private void updateRemainingBalanceLabel(){
        balance_lbl.setText(Float.toString(client.getAccount().getBalance()));
        rem_balance_lbl.setText(Float.toString(client.getAccount().getBalance()));
        current_balance_lbl.setText(Float.toString(client.getAccount().getBalance()));
    }
}
