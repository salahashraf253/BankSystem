package com.example.NotificationsObserver;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    // here we construct the message that is supposed to be sent
    //using set message if withdrawal it should be inside withdrawal to send a message etc
     List<NotificationAbstract> notificationsList = new ArrayList<NotificationAbstract>();
        String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
        notifyAllObservers();
    }


    public void attach (NotificationAbstract notification)
    {
        notificationsList.add(notification);
    }

    public void notifyAllObservers(){
        for (NotificationAbstract notification : notificationsList) {
            notification.NotifyUser();
        }
    }
}
