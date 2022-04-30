package com.example.NotificationsObserver;

public class SendNotificationHelper {

    public SendNotificationHelper(String EmailSubject, String message, String Recipient)
    {
        Subject subject = new Subject();
        new EmailNotification(subject,Recipient);
        new PushNotification(subject);
        subject.setNotification(message,EmailSubject);

    }
}
