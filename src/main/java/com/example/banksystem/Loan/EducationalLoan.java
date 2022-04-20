package com.example.banksystem.Loan;

import com.example.banksystem.User;

public class EducationalLoan extends Loan{
    User u;
    @Override
    public void ApplyForLoan() {
       u.getSSN();
       u.getMonthlyIncome();
       u.getAge();
    }

    @Override
    public double InterestRate(int numOfMonths) {
        if(numOfMonths==6) {
            rate =0.15;
            //return (Amount + rate * Amount) / numOfMonths;
        } else if (numOfMonths==12) {
            rate=0.20;

        }
        return rate;
    }

    @Override
    public double CalcMonthlyPaid(int numOfMonths) {
    return (Amount + rate* Amount) / numOfMonths;
    }
}
