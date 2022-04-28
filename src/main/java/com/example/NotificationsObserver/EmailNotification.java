package com.example.NotificationsObserver;

public class EmailNotification extends NotificationAbstract {

    public EmailNotification(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void NotifyUser()
    {
            //as in send email to him with the message
    }
}
