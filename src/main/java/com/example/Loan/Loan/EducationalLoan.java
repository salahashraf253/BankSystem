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
        if(super.getRepaymentPeriod()==6) {
            rate =0.15;
            //return (Amount + rate * Amount) / numOfMonths;
        } else if (super.getRepaymentPeriod()==12) {
            rate=0.20;

        }
    }

    @Override
    public double CalcMonthlyPaid() {
    return (amount + rate* amount) / super.getRepaymentPeriod();
    }
}
