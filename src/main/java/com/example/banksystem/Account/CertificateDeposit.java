
package com.example.banksystem.Account;

public class CertificateDeposit extends SavingsAccount{
     public CertificateDeposit() {
        accountType = "Certificate Deposit";
    }

    public float Withdraw(float w) {
        float new_balance = getBalance();
        if (new_balance >= w) {
            //penalty
            new_balance = (float) (new_balance - (w * 0.2));
            setBalance(new_balance);
            return new_balance;
        }
        else return 0;
    }
}
