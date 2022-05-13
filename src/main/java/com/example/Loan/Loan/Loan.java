package com.example.Loan.Loan;

import com.example.UserFactory.User;
import com.jfoenix.controls.JFXButton;
import java.time.LocalDate;

public abstract class Loan {
    protected User user = null;
    protected int accountId;
    {

        accountId = user.getUserId();
    }
    protected int loanId;
    protected String loanType;
    protected float amount;
    protected LocalDate startDate;
    protected LocalDate endDate ;
    protected int repaymentPeriod;
    protected double rate ;
    protected String status;
    private JFXButton approveBtn;
    private JFXButton rejectBtn;

    public static int generateLoanId(){
        int id = 0;
        //Get number of Loans from Database then add 1
        return id;
    }

    private void rejectRequest(int accountId, int loanId) {
    }

    private void approveRequest(int accountId, int loanId) {
    }

    public User getUser() {
        return user;
    }

    public int getLoanId() {
        return loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public double getRate() {
        return rate;
    }

    public String getStatus() {
        return status;
    }

    public JFXButton getApproveBtn() {
        return approveBtn;
    }

    public JFXButton getRejectBtn() {
        return rejectBtn;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public abstract void ApplyForLoan();
    public abstract double InterestRate(int numOfMonths);
    public abstract double CalcMonthlyPaid(int numOfMonths);
}
