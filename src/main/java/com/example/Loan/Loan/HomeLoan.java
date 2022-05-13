package com.example.Loan.Loan;

import javafx.collections.ObservableList;

import java.time.LocalDate;

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
        return (amount + rate* amount) / numOfMonths;
    }
}
