package com.example.banksystem.Loan;

public class LoanFactory {

    public Loan GetLoan(String LoanType) {
        if(LoanType == null){
            return null;
        }
        if (LoanType.equalsIgnoreCase("Educational Loan"))
        {
            return new EducationalLoan();
        }
        else if (LoanType.equalsIgnoreCase("Personal Loan"))
        {
            return new PersonalLoan();
        }
         else if (LoanType.equalsIgnoreCase("Home Loan")) {


            return new HomeLoan();

        }
        return null;
    }
}
