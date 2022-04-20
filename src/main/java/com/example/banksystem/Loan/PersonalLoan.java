package com.example.banksystem.Loan;

public class PersonalLoan extends Loan{
    @Override
    public void ApplyForLoan() {
user.getAge();
user.getSSN();
user.getMonthlyIncome();
    }

    @Override
    public double InterestRate(int numOfMonths) {
        rate=2*numOfMonths/100;
        return 0;
    }

    @Override
    public double CalcMonthlyPaid(int numOfMonths) {
        return (Amount + rate* Amount) / numOfMonths;
    }







}
