package com.example.LoanPackage.Loan;

import com.example.UserFactory.User;
import com.example.dataBase.DataBaseMapping;
import com.jfoenix.controls.JFXButton;

import java.sql.Date;
import java.sql.SQLException;

public abstract class Loan {
    protected User user ;
    protected int userId;
    protected int loanId;
    protected String loanType;
    protected float amount;
    protected Date startDate;
    protected Date endDate ;
    protected int repaymentPeriod;
    protected double rate ;
    private String status;
    private double monthlyInstallment;
    private JFXButton approveBtn;
    private JFXButton rejectBtn;

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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
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

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setLoanType(String loanType){
        this.loanType=loanType;
    }

    public int getUserId() {
        return userId;
    }

    public double getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public void setMonthlyInstallment(double monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

    public void setLoanId(int loanId){
        this.loanId=loanId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public abstract void ApplyForLoan() throws SQLException;
    public abstract void calcInterestRate();
    public abstract double CalcMonthlyInstallment();

    public void addLoan() throws SQLException {
        DataBaseMapping.addLoanToDataBase(this);
    }
}
