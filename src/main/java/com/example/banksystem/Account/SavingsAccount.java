
package com.example.banksystem.Account;

public class SavingsAccount extends Account{
     public SavingsAccount() {
        type = "Savings Account";
    }
    public float Withdraw(float w){
        float new_balance = getBalance();
        if(new_balance >= w) {
            new_balance = getBalance() - w;
            setBalance(new_balance);
            return new_balance;
        }
        else return 0;
    }
}
