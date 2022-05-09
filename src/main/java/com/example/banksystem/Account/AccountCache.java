
package com.example.banksystem.Account;


import java.util.Hashtable;

public class AccountCache {

    private static Hashtable<String, Account> accountMap = new Hashtable<String, Account>();

    public static Account getAccount(String accountId) {
        Account cachedAccount = accountMap.get(accountId);
        return (Account) cachedAccount.clone();
    }

    public static void loadCache(){
        if(accountMap.size()==0){
            try {
                System.out.println("Loading Account Map");
                SavingsAccount savings = new SavingsAccount();
                savings.setAccount_no(1);
                String savings_id = Integer.toString(savings.getAccount_no());
                accountMap.put(savings_id,savings);
                Account mm = new MoneyMarket();
                savings.setAccount_no(2);
                String mm_id = Integer.toString(mm.getAccount_no());
                accountMap.put(mm_id,mm);

                Account check_acc = new CheckingAccount();
                savings.setAccount_no(3);
                String check_id = Integer.toString(check_acc.getAccount_no());
                accountMap.put(check_id,check_acc);

                Account cer = new CertificateDeposit();
                cer.setAccount_no(4);
                String cer_id = Integer.toString(cer.getAccount_no());
                accountMap.put(cer_id,cer);
            }
            catch (Exception e){
                System.out.println("Error in load cash ");
                System.out.println(e.getMessage());
            }
        }
        else System.out.println("Account Map is already loaded");
    }
        
}
