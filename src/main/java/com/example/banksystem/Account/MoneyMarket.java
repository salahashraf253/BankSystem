
package com.example.banksystem.Account;

public class MoneyMarket extends CheckingAccount{
    public MoneyMarket() {
        accountType = "MoneyMarket";
    }
    public float Withdraw(float w){
        float new_balance = getBalance();
        if(new_balance>=w) {
            new_balance = getBalance() - w;
            //penalty
            new_balance -= 1.5;
            setBalance(new_balance);
            return new_balance;
        }
        else return 0;
    }
}
