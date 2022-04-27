package com.example.Loan.Loan;

import com.example.UserFactory.User;

import java.util.Date;

public abstract class Loan {
    protected User user = null;
    protected double Amount ;
    protected String status;
    protected Date startedDate ;
    protected Date endDate ;
    protected int numOfMonths ;
    protected double rate ;

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setNumOfMonths(int numOfMonths) {
        this.numOfMonths = numOfMonths;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public abstract void ApplyForLoan();
    public abstract double InterestRate(int numOfMonths);
    public abstract double CalcMonthlyPaid(int numOfMonths);
}
