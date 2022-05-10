package com.example.UserFactory;

import com.example.NotificationsObserver.SendNotificationHelper;
import com.example.banksystem.Account.Account;
import com.example.dataBase.DataBase;
import com.example.dataBase.Functions.DataBaseReader;

import java.util.Date;

public abstract class User {
    protected String firstname;
    protected String lastname;
    protected int Salary;

    protected int SSD;
    protected String phonenumber;
    protected String Email;
    protected Date dob;
    protected String Password;
    protected int UserId;
    protected String Address;


    public User(){

    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getSSD() {
        return SSD;
    }

    public void setSSD(int SSD) {
        this.SSD = SSD;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public abstract void CreateUser(User user);

    public void notifyUser(String subject, String body){
        SendNotificationHelper send=new SendNotificationHelper(subject,body,this.Email);
    }
}
