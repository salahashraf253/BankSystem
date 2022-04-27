
package com.example.banksystem.Account;

public class Account implements Cloneable{
    private String name;
    private int account_no;
    private int user_id;
    private int balance;
    protected String type;
    public float Withdraw(int w){
        float new_balance;
        if(balance >= w) {
            new_balance = balance - w;
            return new_balance;
        }
        else{
            return 0;
        }
    }
    public String getType() {
        return type;
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
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
