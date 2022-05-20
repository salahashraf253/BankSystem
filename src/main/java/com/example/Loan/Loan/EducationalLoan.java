package com.example.Loan.Loan;

import java.sql.SQLException;

public class EducationalLoan extends Loan{
    @Override
    public void ApplyForLoan() throws SQLException {
        calcInterestRate();
        super.addLoan();
    }

    @Override
    public void calcInterestRate() {
        rate =1.6*super.getRepaymentPeriod() /100;
    }

    @Override
    public double CalcMonthlyPaid() {
    return (amount + rate* amount) / super.getRepaymentPeriod();
    }
}
