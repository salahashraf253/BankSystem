
package com.example.banksystem.Account;

public class MoneyMarket extends CheckingAccount{
    private final float withdrawalCost = 1.5F;
    public MoneyMarket() {
        accountType = "MoneyMarket";
    }
    public void withdraw(float amount){
        this.setBalance(this.getBalance()-withdrawalCost);
    }
    public  boolean canWithdraw(double amount) {
        return amount <= this.getBalance()+ withdrawalCost;
    }
}
