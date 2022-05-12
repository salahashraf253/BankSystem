
package com.example.banksystem.Account;

public class SavingsAccount extends Account{
     public SavingsAccount() {
        accountType = "Savings Account";
    }

    @Override
    public boolean canWithdraw(double amount) {
        return amount <= this.getBalance();
    }
}
