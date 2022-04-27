
package com.example.banksystem.Account;

public class CheckingAccount extends Account{

    public float Withdraw(float w){
        float new_balance = getBalance() - w;
        setBalance(new_balance);
        return new_balance;
    }
    public CheckingAccount() {
        type = "Checking Account";
    }
}
