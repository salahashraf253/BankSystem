package com.example.banksystem.Account;

public class SavingsAccount extends Account{
    double interestRate;
     public SavingsAccount() {
        accountType = "Savings Account";
        interestRate=0.1;
    }
    public void updateBalanceWithInterestRate(){
         int yearsPeriod=1;
         this.setBalance((float) (getBalance()* interestRate*yearsPeriod));
    }
}
