package com.example.NotificationsObserver;


import tray.notification.NotificationType;

public class SendNotificationHelper {

    public SendNotificationHelper(String EmailSubject, String message, String Recipient) {
        Subject subject = new Subject();
        new EmailNotification(subject,Recipient);
        new DesktopNotification(subject,EmailSubject ,NotificationType.SUCCESS);
        subject.setNotification(message,EmailSubject);

    }
}
