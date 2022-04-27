package com.example.Loan.Loan;

public class LoanFactory {
    public static Loan getLoan(String loanType) {
        if(loanType.compareTo("Educational")==0 ||loanType.compareTo("e")==0){ //educational
            return new EducationalLoan();
        }
        else if(loanType.compareTo("Home")==0 ||loanType.compareTo("h")==0){   //home
            return new HomeLoan();
        }
        else if(loanType.compareTo("Personal")==0||loanType.compareTo("p")==0){    //personal
            return new PersonalLoan();
        }
        return null;
    }
}
