package com.example.banksystem.Loan;
import com.example.GUI.LoanWindowController;

import java.util.Objects;

public class LoanFactory {
    public static Loan getLoan(String loanType) {
        if(loanType.compareTo("Educational")==0){ //educational
            return new EducationalLoan();
        }
        else if(loanType.compareTo("Home")==0){   //home
            return new HomeLoan();
        }
        else if(loanType.compareTo("Personal")==0){    //personal
            return new PersonalLoan();
        }
        return null;
    }
}
