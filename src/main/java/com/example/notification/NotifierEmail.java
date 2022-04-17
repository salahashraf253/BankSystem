package com.example.notification;

public class NotifierEmail extends Email{

    public void sendNotifierEmail(String recipient, String subject, String body){
        super.sendFromGMail(recipient,subject,body);
    }
}
