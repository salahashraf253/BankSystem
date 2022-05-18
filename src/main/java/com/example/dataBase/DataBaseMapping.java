package com.example.dataBase;
import com.example.Loan.Loan.Loan;
import com.example.Loan.Loan.LoanFactory;
import com.example.UserFactory.Client;
import com.example.UserFactory.FactoryUser;
import com.example.UserFactory.User;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Account.FactoryAccount;
import com.example.banksystem.Transaction;
import com.example.dataBase.Functions.DataBaseReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

/*this class is used for mapping objects for database row*/
public class DataBaseMapping {

    public static User getUser(ResultSet resultSet) throws SQLException {
        //this function take the result set as parameter
        //and return the user if found or null if not found
        try {
            if(resultSet.next()){
                String type=(resultSet.getString("type"));
                System.out.println("type1: "+type);
                User user = FactoryUser.getUserType(type);
                String encrptedUserId=resultSet.getString("user_id");
                String userId=(encrptedUserId);
                user.setUserId(Integer.parseInt(userId));
                System.out.println("type2: "+type);
                System.out.println();;
                assert user != null;
                if(type.compareTo("c")==0){
//                    user=(Client)user;
                    ((Client) user).setAccount(readAccountFromDB(encrptedUserId));
                    user.setType("c");
                }
                else user.setType("a");
                System.out.println("After get Account");
                user.setUserId(Integer.parseInt((resultSet.getString("user_id"))));
                // Email
                user.setEmail((resultSet.getString("email")));
                // Salary
                user.setSalary(Integer.parseInt((resultSet.getString("salary"))));
                // First Name
                user.setFirstname((resultSet.getString("firstName")));
                // Last Name
                user.setLastname((resultSet.getString("lastName")));
                // Phone Number
                user.setPhonenumber((resultSet.getString("phone")));
                //salary
                user.setSalary(Integer.parseInt((resultSet.getString("salary"))));
                return user;
            }
            else{
                System.out.println("Invalid user Id or password");
            }
        }
        catch (Exception e){
            System.out.println("Error in getUser in DataBaseMapping");
            System.out.println(e.getMessage());
        }
        return null;    //invalid user id or password
    }

    public static Account readAccountFromDB(String userID) throws SQLException {
        try{
            System.out.println("USer id:"+userID);
            DataBaseReader dbr=new DataBaseReader();
            String query="select * from bank_account where user_id='"+userID+"';";
            ResultSet accountData=dbr.read(query);
            if(accountData.next()){
                System.out.println("Account of user is found");
                String accountType=(accountData.getString("type"));
                float balance=Float.parseFloat((accountData.getString("balance")));
                String accountNumber=(accountData.getString("account_id"));
                Account unknownAccount =  FactoryAccount.getAccount(accountType);    //checking account
//                unknownAccount.setAccountType(accountType);
                assert unknownAccount != null;
                unknownAccount.setBalance(balance);
                System.out.println("Balance: "+balance);
                unknownAccount.setAccount_no(Integer.parseInt(accountNumber));
                unknownAccount.setUser_id(Integer.parseInt(userID));
                return unknownAccount;
            }
            else System.out.println("no account found");
        }
        catch (Exception e){
            System.out.println("Error in ReadAccount");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ObservableList<Transaction> loadTransactionsFromDataBase(int userId) throws SQLException {
        ObservableList<Transaction> transactionsList = FXCollections.observableArrayList();
        DataBaseReader dbr=new DataBaseReader();
        String query="select * from transaction where user_id='"+userId+"';";
        ResultSet transactionData=dbr.read(query);
        Transaction transaction;
        int transactionID;
        float amount;
        Date date;
        String type;
        while (transactionData.next()){
            transactionID=transactionData.getInt("transaction_id");
            amount=transactionData.getInt("amount");
            date=transactionData.getDate("date");
            type=transactionData.getString("status");
            transaction=new Transaction(transactionID,amount,date,type);
            transactionsList.add(transaction);
        }
        return transactionsList;
    }


    public static ObservableList<Account> getAccounts() throws SQLException {
        ObservableList<Account> list = FXCollections.observableArrayList();
        DataBaseReader db = new DataBaseReader();

        try {
            ResultSet rs=db.read("select * from bank_account");
            while (rs.next())
            {
                Account account  = FactoryAccount.getAccount(rs.getString("type"));
                account.setAccount_no(rs.getInt("account_id"));
                account.setBalance(rs.getFloat("balance"));
                account.setUser_id(rs.getInt("user_id"));
                account.setAccountType(rs.getString("type"));
                list.add(account);

            }
        }

        catch (Exception e){

            System.out.println("Error in get accounts");
            System.out.println(e.getMessage());
        }


        return list;
    }
    public static ArrayList<Loan> getLoans() throws SQLException {
        ArrayList<Loan> loans = new ArrayList<>();
        DataBaseReader db = new DataBaseReader();
        ResultSet rs = db.read("SELECT * from loan");
        try{
            while (rs.next()) {
                ResultSet rs2 = db.read("select * from user where user_id = '" + rs.getInt("user_id") + "';");
                User user = getUser(rs2);
                System.out.println(user.getFirstname());
                user.setUserId(rs.getInt("user_id"));
                Loan loan = LoanFactory.getLoan(rs.getString("loan_type"));
                loan.setAmount(rs.getFloat("amount"));
                loan.setEndDate(rs.getDate("end_date"));
                loan.setStartDate(rs.getDate("start_date"));
                loan.setStatus(rs.getString("status"));
                loan.setRate(rs.getDouble("rate"));
                loan.setRepaymentPeriod(rs.getInt("nOfMonth"));
                loan.setUser(user);
                loan.setUserID(rs.getInt("user_id"));
                loan.setLoanType(rs.getString("loan_type"));
                loans.add(loan);
            }
        }
        catch (Exception e){
            System.out.println("Error In get loan");
            System.out.println(e.getMessage());
        }
        return loans;
    }

    //testing
    public static void main(String[]args) throws SQLException {
        ArrayList<Loan> list=DataBaseMapping.getLoans();
        for (Loan l: list) {
            System.out.println(l.getAmount());
            System.out.println(l.getUser().getUserId());
        }
    }
}
