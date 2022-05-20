package com.example.LoanPackage.LoanIterator;

import com.example.LoanPackage.Loan.Loan;

import java.util.ArrayList;

public class LoanRequestsIterator implements Iterator {
    ArrayList<Loan>requests;
    int index;

    LoanRequestsIterator(ArrayList<Loan> requests) {
        this.requests = requests;
    }

    @Override
    public boolean hasNext() {
        return index < requests.size();
    }
    @Override
    public Object next() {
        if(this.hasNext()){
            return requests.get(index++);
        }
        return null;
    }
}
