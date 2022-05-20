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
        rate =0.1;
    }

    @Override
    public double CalcMonthlyPaid() {
        return 0;
    }


}
