package com.example.banksystem.Loan;
import com.example.GUI.LoanWindowController;

import java.util.Objects;

public class LoanFactory {
    LoanWindowController loanWindowController;

    public Loan GetLoan() {
        if(Objects.equals(loanWindowController.loanSelected, "Educational")){
            return new EducationalLoan();
        }
        if (Objects.equals(loanWindowController.loanSelected, "Personal"))
        {
            return new PersonalLoan();
        }
        else if (Objects.equals(loanWindowController.loanSelected, "Home"))
        {
            return new HomeLoan();
        }

        else
            return null;
    }
}
