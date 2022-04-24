package com.example.banksystem.LoanIterator;

public class LoanRequestsIterator implements Iterator {
    LoanRequest[] requests;
    int index;

    LoanRequestsIterator(LoanRequest[] requests) {
        this.requests = requests;
    }





    @Override
    public boolean hasNext() {
        if(index < requests.length){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {

        if(this.hasNext()){
            return requests[index++];
        }
        return null;


    }
}
