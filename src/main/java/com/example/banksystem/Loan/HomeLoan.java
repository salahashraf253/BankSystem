package com.example.banksystem.Loan;

public class HomeLoan extends Loan{
    @Override
    public void ApplyForLoan() {

    }

    @Override
    public double InterestRate(int numOfMonths) {
      return  rate;
    }

    @Override
    public double CalcMonthlyPaid(int numOfMonths) {
        return (Amount + rate* Amount) / numOfMonths;
    }
}
