package com.example.LoanPackage.LoanIterator;

import com.example.LoanPackage.Loan.Loan;
public class LoanRequest {
    private Loan loan;
    private String status;
    private  int UserID;
    public LoanRequest(Loan loan, String status, int UserID) {
        this.loan = loan;
        this.status = status;
        this.UserID = UserID;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

}
