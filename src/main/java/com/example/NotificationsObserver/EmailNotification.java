package com.example.NotificationsObserver;

public class EmailNotification extends NotificationAbstract {

    String Recipient;
    public EmailNotification(Subject subject, String recipient){
        this.subject = subject;
        this.subject.attach(this);
        this.Recipient = recipient;
    }

    public void notifyUser(){
//        NotifierEmail email = new NotifierEmail();
//        email.sendNotifierEmail(Recipient, subject.getemailsubject(), subject.getMessage());
            //as in send email to him with the message
    }
}
