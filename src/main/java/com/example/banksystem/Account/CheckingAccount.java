
package com.example.banksystem.Account;

public class CheckingAccount extends Account{


    @Override
    public boolean canWithdraw(double amount) {
        return amount <= this.getBalance();
    }

    public CheckingAccount() {
        accountType = "Checking Account";
    }
}
