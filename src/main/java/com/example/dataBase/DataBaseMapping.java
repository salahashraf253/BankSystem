package com.example.dataBase;
import com.example.Generator.Generator;
import com.example.Generator.IdGenerator;
import com.example.LoanPackage.Loan.Loan;
import com.example.LoanPackage.Loan.LoanFactory;
import com.example.UserFactory.Client;
import com.example.UserFactory.FactoryUser;
import com.example.UserFactory.User;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Account.FactoryAccount;
import com.example.banksystem.Transaction;
import com.example.dataBase.Functions.DataBaseReader;
import com.example.dataBase.Functions.DataBaseUpdater;
import com.example.dataBase.Functions.DataBaseWriter;
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
                user.setFirstName((resultSet.getString("firstName")));
                // Last Name
                user.setLastName((resultSet.getString("lastName")));
                // Phone Number
                user.setPhoneNumber((resultSet.getString("phone")));
                //salary
                user.setSalary(Integer.parseInt((resultSet.getString("salary"))));
                user.setAddress(resultSet.getString("address"));
                user.setDob(resultSet.getDate("dob"));
                user.setGender(resultSet.getString("gender"));
                user.setMaritalStatus(resultSet.getString("status"));
                user.setSSN((resultSet.getString("ssn")));
                user.setOccupation(resultSet.getString("job"));

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
            while (rs.next()) {
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
    public static ArrayList<Loan> getLoans(int userID) throws SQLException {
        ArrayList<Loan> loans = new ArrayList<>();
        DataBaseReader db = new DataBaseReader();
        String query="select * from loan";
        if(userID!=-1){
            query+=" where user_id ='"+userID+"'";
        }
        ResultSet rs = db.read(query);
        try{
            while (rs.next()) {
                ResultSet rs2 = db.read("select * from user where user_id = '" + rs.getInt("user_id") + "';");
                User user = getUser(rs2);
                System.out.println(user.getFirstName());
                user.setUserId(rs.getInt("user_id"));
                Loan loan = LoanFactory.getLoan(rs.getString("loan_type"));
                loan.setAmount(rs.getFloat("amount"));
                loan.setUserId(rs.getInt("user_id"));
                loan.setEndDate(rs.getDate("end_date"));
                loan.setStartDate(rs.getDate("start_date"));
                loan.setStatus(rs.getString("status"));
                loan.setRate(rs.getDouble("rate"));
                loan.setRepaymentPeriod(rs.getInt("nOfMonth"));
                loan.setUser(user);
                loan.setLoanId(rs.getInt("loan_id"));
                loan.setLoanType(rs.getString("loan_type"));
                loan.setMonthlyInstallment(rs.getDouble("monthlyPaid"));
                loans.add(loan);
            }
        }
        catch (Exception e){
            System.out.println("Error In get loan");
            System.out.println(e.getMessage());
        }
        return loans;
    }
    public static void addLoanToDataBase(Loan loan) throws SQLException {
        DataBaseWriter dataBaseWriter=new DataBaseWriter();
        loan.setLoanId(new IdGenerator().generate(Generator.generator.loan_id));
        loan.setUserId(loan.getUser().getUserId());
        String query="insert into loan" +
                " (loan_id,user_id,loan_type,amount,status,nOfMonth,rate," +
                "start_Date,end_date,monthlyPaid)"+
                "VALUES(" +
                "'" + loan.getLoanId()+ "'," +
                "'" + loan.getUserId()+ "'," +
                "'" + loan.getLoanType()+ "'," +
                "'" + loan.getAmount()+ "'," +
                "'" + "pending" + "'," +
                "'" + loan.getRepaymentPeriod() + "'," +
                "'" + loan.getRate()+ "'," +
                "'"+loan.getStartDate()+"',"+
                "'"+loan.getEndDate()+"',"+
                "'"+loan.getMonthlyInstallment()+
                "')";
        dataBaseWriter.write(query);
    }
    public static void addUserToDataBase(Client user) throws SQLException {
        DataBaseWriter dataBaseWriter = new DataBaseWriter();
        String query = "insert into user" +
                " (user_id,ssn,email,password,firstName,lastName, " +
                "salary, phone,address,status,gender,type,job)" +
                "VALUES(" +
                "'" + user.getUserId() + "'," +
                "'" + user.getSSN() + "'," +
                "'" + user.getEmail() + "'," +
                "'" + user.getPassword() + "'," +
                "'" + user.getFirstName() + "'," +
                "'" + user.getLastName() + "'," +
                "'" + user.getSalary() + "'," +
                "'" + user.getPhoneNumber() + "'," +
                "'" + user.getAddress() + "'," +
                "'" + user.getStatus() + "'," +
                "'" + user.getGender() + "'," +
                "'" + "c" + "'," +  //c : client
                "'" + user.getOccupation() +"'" +
                ")";
        dataBaseWriter.write(query);
        Account.addAccount(user.getAccount());
    }
    public static void addTransactionToDataBase(Transaction transaction) throws SQLException {
        DataBaseWriter dataBaseWriter=new DataBaseWriter();
        String query="insert into transaction" +
                " (transaction_id,user_id,amount,status,date)"+
                "VALUES(" +
                "'" + transaction.getTransactionID() + "'," +
                "'" + transaction.getUserId() + "'," +
                "'" + transaction.getAmount() + "'," +
                "'" + transaction.getType() + "'," +
                "'"+ transaction.getDate() +"'"+
                ")";
        dataBaseWriter.write(query);
    }
    public static void updateBalanceInDataBase(float balance, int userID) throws SQLException {
        DataBaseUpdater dataBaseUpdater=new DataBaseUpdater();
        String query="update bank_account set balance='" +balance+"' where user_id='" + userID +"';";
        dataBaseUpdater.update(query);
    }
    public static void transferMoney(int toAccount, float amount) throws SQLException {
        DataBaseUpdater dataBaseUpdater=new DataBaseUpdater();
        DataBaseReader dataBaseReader =new DataBaseReader();
        String query="select * from bank_account where account_id='"+toAccount+"';";
        ResultSet resultSet=dataBaseReader.read(query);
        float toAccountBalance=0;
        if(resultSet.next()){
            System.out.println("Account to transfer is found");
            toAccountBalance=Float.parseFloat(resultSet.getString("balance"));
            System.out.println(toAccountBalance);
        }
        float newBalance=toAccountBalance + amount;
        System.out.println("New Balance: "+newBalance);
        query="update bank_account set balance='" +(int)newBalance+"' where account_id='" + toAccount +"';";
        dataBaseUpdater.update(query);
    }
    public static void addAccountInDataBase(Account account) throws SQLException {
        String q="insert into bank_account" +
                " (user_id,account_id,balance,type)"+
                "VALUES(" +
                "'" + account.getUser_id() + "'," +
                "'" + account.getAccount_no() + "'," +
                "'" + account.getBalance() + "'," +
                "'"+ account.getAccountType() +"'"+
                ")";
        DataBaseWriter dataBaseWriter=new DataBaseWriter();
        dataBaseWriter.write(q);
    }
}
