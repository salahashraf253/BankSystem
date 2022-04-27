/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.banksystem.Account;

/**
 *
 * @author Admin
 */
public class CheckingAccount extends Account{

    public float Withdraw(float w){
        float new_balance = getBalance() - w;
        return new_balance;
    }
    public CheckingAccount() {
        type = "Checking Account";
    }
}
