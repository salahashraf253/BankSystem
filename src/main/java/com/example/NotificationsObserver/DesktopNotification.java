package com.example.NotificationsObserver;

import tray.notification.NotificationType;

public class DesktopNotification extends NotificationAbstract{
    private  NotificationType notificationType;
    public DesktopNotification(Subject subject, String message, NotificationType notificationType) {
        this.message=message;
        this.subject=subject;
        this.subject.attach(this);
        this.notificationType=notificationType;
    }
    public DesktopNotification(String message, NotificationType notificationType) {
        this.message=message;
        this.notificationType=notificationType;
    }
    public DesktopNotification() {

    }

    @Override
    public void notifyUser() {
        DesktopNotificationBuilder.notifyUser(subject.Message, this.notificationType);
    }
}
