
package com.example.banksystem.Account;

public class FactoryAccount {
    public static Account getAccount(String accountType){
        if(accountType.compareToIgnoreCase("Saving")==0){
            return new SavingsAccount();
        }
        else if(accountType.compareToIgnoreCase("Money Market")==0){
            return new MoneyMarket();
        }
        else if(accountType.compareToIgnoreCase("Certificate")==0){
            return new CertificateDeposit();
        }
        else if(accountType.compareToIgnoreCase("Checking")==0){
            return new CheckingAccount();
        }
        return null;
    }
}
