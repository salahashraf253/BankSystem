package com.example.UserFactory;

import com.example.NotificationsObserver.SendNotificationHelper;

import java.util.Date;

public abstract class User {
    protected String firstName;
    protected String lastName;
    protected int Salary;
    protected String SSN;
    protected String phoneNumber;
    protected String Email;
    protected Date dob;
    protected String Password;
    protected int UserId;
    protected String Address;
    protected String type;
    protected String gender;
    protected String status;
    protected String maritalStatus;
    protected String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public User(){

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void notifyUser(String subject, String body){
        SendNotificationHelper send=new SendNotificationHelper(subject,body,this.Email);
    }

    public void setType(String type){
        this.type=type;
    }
    public String getType() {
        return type;
    }
    public String getGender() {
        return gender;
    }
    public String getStatus() {
        return status;
    }

}
