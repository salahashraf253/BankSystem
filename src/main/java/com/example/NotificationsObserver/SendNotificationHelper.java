package com.example.NotificationsObserver;


import tray.notification.NotificationType;

public class SendNotificationHelper {

    public SendNotificationHelper(String EmailSubject, String message, String Recipient)
    {
        Subject subject = new Subject();
        new EmailNotification(subject,Recipient);
        new PushNotification(subject);
        new NotificationBuilder(subject,EmailSubject ,NotificationType.SUCCESS);
        subject.setNotification(message,EmailSubject);

    }
    public static void main(String []args)  {
        SendNotificationHelper sendNotificationHelper=
                new SendNotificationHelper("Hello", "heyyo", "salahashraf924@gmail.com");

    }
}
