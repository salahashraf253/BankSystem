package com.example.Loan.LoanIterator;

import com.example.Loan.Loan.Loan;
import com.example.Loan.Loan.LoanFactory;
import com.example.Loan.Loan.*;
import com.example.dataBase.DataBaseMapping;
import com.example.dataBase.Functions.DataBaseReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanRequestsRepo implements  Container{

    //i need a function in database class to read all loan requests
//    private List<LoanRequest> loanRequestList=getAllLoanRequests(); //DataBase.getLoanRequests();
    private Iterator LoanIter;
    public ArrayList<Loan> loanReqs;
//    {
//        try {
//            loanReqs = DataBaseMapping.getLoans();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public LoanRequestsRepo(int userID) throws SQLException {
        try {
            loanReqs = DataBaseMapping.getLoans(userID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    private static List<LoanRequest> getAllLoanRequests() throws SQLException {
//        List<LoanRequest> loanRequestList=new ArrayList<>();
//        DataBaseReader dataBaseReader=new DataBaseReader();
//        String query="select * from loan";
//        ResultSet resultSet=dataBaseReader.read(query);
//        Loan loan;
//        String status;
//        String loanType;
//        int userId;
//        int idx=0;
//        //Note: the way of assigning values to object from database I search for a better way than it
//        while (resultSet.next()){
//            status=resultSet.getString("status");
//            userId=resultSet.getInt("user_id");
//            loanType=resultSet.getString("loan_type");
//            loan= LoanFactory.getLoan(loanType);
//            assert loan != null;
//            loan.setAmount(resultSet.getDouble("amount"));
//            loan.setNumOfMonths(resultSet.getInt("nOfMonth"));
//            loanRequestList.add(new LoanRequest(loan,status,userId));
//        }
//        dataBaseReader.closeConnection();
//        return loanRequestList;
//    }
    @Override
    public Iterator getIterator() {
        LoanIter = new LoanRequestsIterator(loanReqs) ;
        return LoanIter;
    }


}
