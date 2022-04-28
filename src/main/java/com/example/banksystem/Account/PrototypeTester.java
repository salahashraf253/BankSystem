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
public class PrototypeTester {

    public static void main(String[] args) {
        AccountCache.loadCache();
        Account clonedAcc1 = (Account) AccountCache.getAccount("1");
        System.out.println("Account : " + clonedAcc1.getType());
        
        Account clonedAcc2 = AccountCache.getAccount("2");
        System.out.println("Account : " + clonedAcc2.getType());
        
        Account clonedAcc3 = AccountCache.getAccount("3");
        System.out.println("Account : " + clonedAcc3.getType());
    }
}
