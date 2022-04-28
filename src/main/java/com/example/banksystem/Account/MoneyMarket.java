/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.banksystem.Account;

public class MoneyMarket extends CheckingAccount{
    public MoneyMarket() {
        type = "MoneyMarket";
    }
    public float Withdraw(float w){
        float new_balance = getBalance() - w;
        //penalty
        new_balance -= 1.5;
        setBalance(new_balance);
        return new_balance;
    }
}
