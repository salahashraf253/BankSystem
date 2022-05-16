
package com.example.banksystem.Account;

import com.example.dataBase.Functions.DataBaseUpdater;
import com.example.dataBase.Functions.DataBaseWriter;
import com.jfoenix.controls.JFXButton;

import java.sql.SQLException;

public abstract class Account {
    private String name;
    private int accountNo;
    private int userId;
    private float balance;
    protected String accountType;

    public void setUpdateBtn() {
        this.updateBtn = new JFXButton("Update");
    }

    public void setDeleteBtn() {
        this.deleteBtn = new JFXButton("Delete");

    }

    public JFXButton getUpdateBtn() {
        return updateBtn;
    }

    public JFXButton getDeleteBtn() {
        return deleteBtn;
    }

    private JFXButton updateBtn;
    private JFXButton deleteBtn;

    public  void withdraw(float amount){
        this.balance-=amount;
    }
    public String getAccountType() {
        return accountType;
    }
    public int getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
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
    public int getUserId() {
        return userId;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void setAccountType(String accountType){
        this.accountType =accountType;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }
    public static void addAccount(Account account) throws SQLException {
        String q="insert into bank_account" +
                " (user_id,account_id,balance,type)"+
                "VALUES(" +
                "'" + account.userId + "'," +
                "'" + account.accountNo + "'," +
                "'" + account.balance + "'," +
                "'"+account.accountType+"'"+
                ")";
        DataBaseWriter dataBaseWriter=new DataBaseWriter();
        dataBaseWriter.write(q);
        dataBaseWriter.closeConnection();
    }

    public boolean canWithdraw(double amount){
        return this.balance<=amount;
    }
    public void updateBalance(float amount) throws SQLException {
        DataBaseUpdater dataBaseUpdater=new DataBaseUpdater();
        String query="update bank_account set balance='" +balance+"' where user_id='" + userId +"';";
        dataBaseUpdater.update(query);
    }
}
