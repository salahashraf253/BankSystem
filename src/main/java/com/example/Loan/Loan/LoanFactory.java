package com.example.Loan.Loan;

public class LoanFactory {
    public static Loan getLoan(String loanType) {
        if(loanType.compareToIgnoreCase("Educational")==0 ||loanType.compareToIgnoreCase("e")==0){ //educational
            return new EducationalLoan();
        }
        else if(loanType.compareToIgnoreCase("Home")==0 ||loanType.compareToIgnoreCase("h")==0){   //home
            return new HomeLoan();
        }
        else if(loanType.compareToIgnoreCase("Personal")==0||loanType.compareToIgnoreCase("p")==0){    //personal
            return new PersonalLoan();
        }
        return null;
    }
}
