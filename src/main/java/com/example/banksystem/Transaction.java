package com.example.banksystem;

import com.example.dataBase.DataBaseMapping;
import com.example.dataBase.Functions.DataBaseReader;
import com.example.dataBase.Functions.DataBaseWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

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
//        ObservableList<Transaction> list = FXCollections.observableArrayList();
//        list.add(new Transaction(100,540,new Date(2022,5,1),"Withdraw"));
//        list.add(new Transaction(101,1000,new Date(2022,4,18),"Deposit"));
//        return list;
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
        DataBaseWriter dataBaseWriter=new DataBaseWriter();
        String query="insert into transaction" +
                " (transaction_id,user_id,amount,status,date)"+
                "VALUES(" +
                "'" + transaction.transactionID + "'," +
                "'" + transaction.userId + "'," +
                "'" + transaction.amount + "'," +
                "'" + transaction.type + "'," +
                "'"+transaction.date+"'"+
                ")";
        dataBaseWriter.write(query);
    }

}
