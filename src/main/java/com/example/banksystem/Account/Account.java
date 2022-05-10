
package com.example.banksystem.Account;

import com.example.dataBase.Functions.DataBaseWriter;

import java.sql.SQLException;

public abstract class Account {
    private String name;
    private int account_no;
    private int user_id;
    private float balance;
    protected String accountType;
    public float Withdraw(float w){
        if(balance >= w) {
            balance = balance - w;
            return balance;
        }
        else return 0;
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

    public void setUser_id(int user_id){
        this.user_id=user_id;
    }
    public static void addAccount(Account account) throws SQLException {
        String q="insert into bank_account" +
                " (user_id,account_id,balance,type)"+
                "VALUES(" +
                "'" + account.user_id + "'," +
                "'" + account.account_no + "'," +
                "'" + account.balance + "'," +
                "'"+account.accountType+"'"+
                ")";
        DataBaseWriter dataBaseWriter=new DataBaseWriter();
        dataBaseWriter.write(q);
        dataBaseWriter.closeConnection();
    }
}
