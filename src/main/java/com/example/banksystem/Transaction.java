package com.example.banksystem;

import com.example.dataBase.DataBaseMapping;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.SQLException;

public class Transaction {
    private int userId;
    private int transactionID;
    private float amount;
    private Date date;
    private String type;
    private int accountId;

    public Transaction(int transactionID, float amount, Date date, String type) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }
    public Transaction(int userId,int transactionID, float amount, Date date, String type) {
        this.userId=userId;
        this.transactionID = transactionID;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }
    public static ObservableList<Transaction> getTransactions(int userID) throws SQLException {
        return DataBaseMapping.loadTransactionsFromDataBase(userID);
    }

    public int getUserId() {
        return userId;
    }
    public int getTransactionID() {
        return transactionID;
    }
    public float getAmount() {
        return amount;
    }
    public Date getDate() {
        return date;
    }
    public String getType() {
        return type;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public static void addTransaction(Transaction transaction) throws SQLException {
        DataBaseMapping.addTransactionToDataBase(transaction);
    }

}
