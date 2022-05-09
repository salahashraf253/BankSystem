package com.example.dataBase;
import com.example.UserFactory.Client;
import com.example.UserFactory.FactoryUser;
import com.example.UserFactory.User;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Account.AccountCache;
import com.example.dataBase.Functions.DataBaseReader;
import com.example.dataBase.Functions.DecryptString;
import java.sql.ResultSet;
import java.sql.SQLException;
/*this class is used for mapping objects for database row*/
public class DataBaseMapping {

    public static User getUser(ResultSet resultSet) throws SQLException {
        //this function take the result set as parameter
        //and return the user if found or null if not found
        try {
            if(resultSet.next()){
                String type=DecryptString.getDecrptString(resultSet.getString("type"));
                System.out.println("type1: "+type);
                User user = FactoryUser.getUserType(type);
                String encrptedUserId=resultSet.getString("user_id");
                String userId=DecryptString.getDecrptString(encrptedUserId);
                user.setUserId(Integer.parseInt(userId));
                System.out.println("type2: "+type);
                System.out.println();;
                assert user != null;
                if(type.compareTo("c")==0){
                    user=(Client)user;
                    ((Client) user).setAccount(readAccountFromDB(encrptedUserId));
                }
                System.out.println("After get Account");
                user.setUserId(Integer.parseInt(DecryptString.getDecrptString(resultSet.getString("user_id"))));
                // Email
                user.setEmail(DecryptString.getDecrptString(resultSet.getString("email")));
                // Salary
                user.setSalary(Integer.parseInt(DecryptString.getDecrptString(resultSet.getString("salary"))));
                // First Name
                user.setFirstname(DecryptString.getDecrptString(resultSet.getString("firstName")));
                // Last Name
                user.setLastname(DecryptString.getDecrptString(resultSet.getString("lastName")));
                // Phone Number
                user.setPhonenumber(DecryptString.getDecrptString(resultSet.getString("phone")));
                //salary
                user.setSalary(Integer.parseInt(DecryptString.getDecrptString(resultSet.getString("salary"))));
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
                String accountType=DecryptString.getDecrptString(accountData.getString("type"));
                float balance=Float.parseFloat(DecryptString.getDecrptString(accountData.getString("balance")));
                String accountNumber=DecryptString.getDecrptString(accountData.getString("account_id"));
                AccountCache.loadCache();
                Account clonedAccount =  AccountCache.getAccount("1");    //checking account
                clonedAccount.setAccountType(accountType);
                clonedAccount.setBalance(balance);
                System.out.println("Balance: "+balance);
                clonedAccount.setAccount_no(Integer.parseInt(accountNumber));
//                clonedAcc1.setUser_id(Integer.parseInt(userID));
                return clonedAccount;
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
