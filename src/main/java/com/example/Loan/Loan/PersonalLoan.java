package com.example.Loan.Loan;


public class PersonalLoan extends Loan{

    @Override
    public void ApplyForLoan() {

    }

    @Override
    public double InterestRate(int numOfMonths) {
        rate=2*numOfMonths/100;
        return 0;
    }

    @Override
    public double CalcMonthlyPaid(int numOfMonths) {
        return (amount + rate* amount) / numOfMonths;
    }


}
