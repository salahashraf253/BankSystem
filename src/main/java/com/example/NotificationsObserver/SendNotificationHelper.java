package com.example.NotificationsObserver;



import java.sql.SQLException;

public class SendNotificationHelper {

    public SendNotificationHelper(String EmailSubject, String message, String Recipient)
    {
        Subject subject = new Subject();
        new EmailNotification(subject,Recipient);
        new PushNotification(subject);
        subject.setNotification(message,EmailSubject);

    }
    public static void main(String []args)  {
        SendNotificationHelper sendNotificationHelper=
                new SendNotificationHelper("Hello", "heyyo", "salma");

    }
}
