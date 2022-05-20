package com.example.Loan.Loan;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.time.LocalDate;

public class HomeLoan extends Loan{
    @Override
    public void ApplyForLoan() throws SQLException {
        calcInterestRate();
        super.addLoan();
    }

    @Override
    public void calcInterestRate() {
        rate =1.4*super.getRepaymentPeriod() /100;
    }

    @Override
    public double CalcMonthlyPaid() {
        return (amount + rate* amount) / super.getRepaymentPeriod();
    }


}
