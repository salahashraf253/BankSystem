package com.example.NotificationsObserver;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    // here we construct the message that is supposed to be sent
    //using set message if withdrawal it should be inside withdrawal to send a message etc
     List<NotificationAbstract> notificationsList = new ArrayList<NotificationAbstract>();
        String Message;
        String emailSubject;

    public String getMessage() {
        return Message;
    }
    public String getemailsubject() {
        return emailSubject;
    }

    public void setNotification(String message, String emailsubject) {
        Message = message;
        this.emailSubject= emailsubject;
        notifyAllObservers();
    }

   

    public void attach (NotificationAbstract notification) {
        notificationsList.add(notification);
    }

    private void notifyAllObservers(){
        for (NotificationAbstract notification : notificationsList) {
            notification.notifyUser();
        }
    }
}
