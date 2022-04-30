
package com.example.banksystem.Account;

public class Account implements Cloneable{
    private String name;
    private int account_no;
    private int user_id;
    private float balance;
    protected String type;
    public float Withdraw(float w){
        if(balance >= w) {
            balance = balance - w;
            return balance;
        }
        else return 0;
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
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
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
