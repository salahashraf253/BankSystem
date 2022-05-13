package com.example.Loan.Loan;

public class EducationalLoan extends Loan{
    @Override
    public void ApplyForLoan() {

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
    return (amount + rate* amount) / numOfMonths;
    }
}
