
package com.example.banksystem.Account;

import com.example.GUI.PageLoader;
import com.example.dataBase.DataBaseMapping;
import com.jfoenix.controls.JFXButton;

import java.sql.SQLException;

public abstract class Account {
    private String name;
    private int account_no;
    private int user_id;
    private float balance;
    protected String accountType;

    protected JFXButton updateBtn = new JFXButton("     Update     ");
    protected JFXButton deleteBtn = new JFXButton("     Delete     ");

    public  void withdraw(float amount){
        this.balance-=amount;
    }
    public  void deposit(float amount){
        this.balance+=amount;
    }
    public String getAccountType() {
        return accountType;
    }
    public int getAccount_no() {
        return account_no;
    }
    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getBalance() {
        return this.balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void setAccountType(String accountType){
        this.accountType =accountType;
    }
    public int getUser_id() {
        return user_id;
    }

    public JFXButton getUpdateBtn() {
        return updateBtn;
    }

    public JFXButton getDeleteBtn() {
        return deleteBtn;
    }
    public void setUser_id(int user_id){
        this.user_id=user_id;
    }

    public void setUpdateBtn() {
        this.updateBtn = new JFXButton("Update");
        this.updateBtn.setOnAction(actionEvent ->{updateAccount();});
    }

    public void setDeleteBtn() {
        this.deleteBtn = new JFXButton("Delete");
    }
    public void updateAccount(){
        PageLoader pageLoader = new PageLoader();
        pageLoader.loadPage("/com/example/banksystem/Update Accout.fxml",null,false,false);
    }
    public static void addAccount(Account account) throws SQLException {
        DataBaseMapping.addAccountInDataBase(account);
    }

    public boolean canWithdraw(double amount){
        return this.balance>=amount;
    }
    public boolean canTransferMoney(float amount){
        return this.balance >= amount;
    }
    public void updateBalance() throws SQLException {
        DataBaseMapping.updateBalanceInDataBase(this.balance,this.user_id);
    }
    public void transferMoney(int toAccount, float amount) throws SQLException {
        this.balance-=amount;
        DataBaseMapping.transferMoney(toAccount,amount);
    }
}
