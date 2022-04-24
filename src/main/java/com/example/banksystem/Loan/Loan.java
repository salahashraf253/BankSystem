package com.example.banksystem.Loan;

import com.example.UserFactory.User;

import java.util.Date;

abstract public class Loan {
    User user = null;
    double Amount ;
    String status;
    Date startedDate ;
    Date endDate ;
    int numOfMonths ;
    double rate ;
    public abstract void ApplyForLoan();
    public abstract double InterestRate(int numOfMonths);
    public abstract double CalcMonthlyPaid(int numOfMonths);
}
