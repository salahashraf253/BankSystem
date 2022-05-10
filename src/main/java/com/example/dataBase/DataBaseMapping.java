package com.example.dataBase;
import com.example.UserFactory.Client;
import com.example.UserFactory.FactoryUser;
import com.example.UserFactory.User;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Account.FactoryAccount;
import com.example.dataBase.Functions.DataBaseReader;

import java.sql.ResultSet;
import java.sql.SQLException;
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
                    user=(Client)user;
                    ((Client) user).setAccount(readAccountFromDB(encrptedUserId));
                }
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
//                clonedAcc1.setUser_id(Integer.parseInt(userID));
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
}
