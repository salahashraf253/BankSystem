package com.example.NotificationsObserver;

public class PushNotification extends NotificationAbstract {

    public PushNotification(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void NotifyUser()
    {
        //send push notification with the message
        System.out.println( "Message: " +subject.getMessage() );
    }
}
