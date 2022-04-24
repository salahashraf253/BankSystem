package com.example.banksystem.LoanIterator;

public class LoanRequestsRepo implements  Container{

    //i need a function in database class to read all loan requests
    public LoanRequest [] requests =null; //DataBase.getLoanRequests();
    private Iterator LoanIter;



    @Override
    public Iterator getIterator() {
        LoanIter = new LoanRequestsIterator(requests);
        return LoanIter;
    }
}
