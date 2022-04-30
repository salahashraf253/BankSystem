
package com.example.banksystem.Account;

public class PrototypeTester {

    public static void main(String[] args) {
        AccountCache.loadCache();
        Account clonedAcc1 = (Account) AccountCache.getAccount("1");
        System.out.println("Account : " + clonedAcc1.getType());
    }
}
