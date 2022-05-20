package com.example.Api.EmailApi;

public class NotifierEmail extends Email{

    public void sendNotifierEmail(String recipient, String subject, String body){
        super.setEmailSubject(subject);
        super.setEmailBody(body);
        super.sendEmail(recipient);
    }
}
