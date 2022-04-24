package com.example.banksystem.Loan;
import com.example.GUI.LoanWindowController;
public class LoanFactory {
    LoanWindowController loanWindowController;

    public Loan GetLoan() {
        if(loanWindowController.loanSelected=="Educational"){
            return new EducationalLoan();
        }
        if (loanWindowController.loanSelected=="Personal")
        {
            return new PersonalLoan();
        }
        else if (loanWindowController.loanSelected=="Home")
        {
            return new HomeLoan();
        }

        else
            return null;
    }
}
