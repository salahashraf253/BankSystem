package com.example.Loan.LoanIterator;

public class LoanRequestsIterator implements Iterator {
    LoanRequest[] requests;
    int index;

    LoanRequestsIterator(LoanRequest[] requests) {
        this.requests = requests;
    }

    @Override
    public boolean hasNext() {
        return index < requests.length;
    }
    @Override
    public Object next() {
        if(this.hasNext()){
            return requests[index++];
        }
        return null;
    }
}
