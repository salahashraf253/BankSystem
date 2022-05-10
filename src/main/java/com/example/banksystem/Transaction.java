package com.example.banksystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

import java.sql.Date;
import java.util.ArrayList;

public class Transaction {
    private int transactionID;
    private int userId;
    private float amount;
    private Date date;
    private String type;

    private Transaction(int transactionID, float amount, Date date, String type) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public static ObservableList<Transaction> getTransactions(int userID){
        ObservableList<Transaction> list= FXCollections.observableArrayList();
        list.add(new Transaction(100,540,new Date(1,1,1),"Withdraw"));
        list.add(new Transaction(101,1000,new Date(2,1,1),"Deposit"));
        return list;
    }
}
