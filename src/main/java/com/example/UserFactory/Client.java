package com.example.UserFactory;

import com.example.banksystem.Account.Account;
import com.example.banksystem.Transaction;
import com.example.dataBase.Functions.DataBaseWriter;

import java.sql.SQLException;


public class Client extends User{


   /* public UserFactory.Client(String name, int SSD, int phonenumber, Date dob, String password, String username, String address) {
        super(name, SSD, phonenumber, dob, password, username, address);
    }*/
    private Account account;
    private Transaction transaction;
    public Client(String firstName, String lastName, int userId,int ssd, String password, String email, Account account,
                  int salary,String address,String status,String gender){
        this.account=account;
        this.firstName =firstName;
        this.lastName =lastName;
        this.UserId=userId;
        this.Password=password;
        this.Salary=salary;
        this.Email=email;
        this.SSN =ssd;
        this.Address=address;
        this.status=status;
        this.gender=gender;
    }
    public Client(){

    }

    public void setAccount(Account account){
        this.account=account;
    }
    public Account getAccount(){
        return this.account;
    }
    public static void CreateUser(Client user) throws SQLException {
        //in database mara wa7da
        // like UserFactory.Client (user.name ,user.ssd , ...etc)
        //insert into UserFactory.Client values
        System.out.println("here in client");
        DataBaseWriter dataBaseWriter=new DataBaseWriter();
        String query="insert into user" +
                " (user_id,ssn,email,password,firstName,lastName, " +
                "salary, phone,address,status,gender,type)"+
                "VALUES(" +
                "'" + user.getUserId()+ "'," +
                        "'" + user.getSSN() + "'," +
                        "'" + user.getEmail() + "'," +
                        "'" + user.getPassword() + "'," +
                        "'" + user.getFirstName() + "'," +
                        "'" + user.getLastName() + "'," +
                        "'" + user.getSalary() + "'," +
                        "'"+user.getPhoneNumber()+"',"+
                        "'"+user.getAddress()+"',"+
                        "'"+user.getStatus()+"',"+
                         "'"+user.getGender()+"',"+
                          "'"+"c"+"'"+  //c : client
                              ")";
        dataBaseWriter.write(query);
        Account.addAccount(user.account);
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void addTransaction() throws SQLException {
        this.transaction.addTransaction(this.transaction);
    }

//    private String name;
//    private int account_no;
//    private int user_id;
//    private float balance;
//    protected String type;
}
