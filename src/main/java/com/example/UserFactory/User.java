package com.example.UserFactory;

import java.util.Date;

public abstract class User {
    String name;
    int SSD;
    int phonenumber;
    Date dob;
    String Password;
    String username;
    String Address;

    /*public UserFactory.User(String name, int SSD, int phonenumber, Date dob, String password, String username, String address) {
        this.name = name;
        this.SSD = SSD;
        this.phonenumber = phonenumber;
        this.dob = dob;
        Password = password;
        this.username = username;
        Address = address;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSSD() {
        return SSD;
    }

    public void setSSD(int SSD) {
        this.SSD = SSD;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public abstract void CreateUser(User user);
    //public abstract void Login();
    //public abstract void UpdateUser();
    //public abstract void DeleteUser();
}
