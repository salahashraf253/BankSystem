package com.example.notification;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public abstract class Email {
    private final String userName = "username";  // gmail username (just the part before "@gmail.com")
    private final String password = "***********"; // gmail password
    private final String host = "smtp.gmail.com";
    protected String fontType="font-family:'Times New Roman'";
    private String emailSubject;
    private String emailBody;


    public void sendFromGMail(String recipient) {
        String []to={recipient};
        Properties properties= getProperties();
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(userName));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            message.setSubject(emailSubject);
            message.setContent(emailBody,"text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, userName, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Authentication code is sent Successfully"); //the code is sent without any problems
        }
        catch (MessagingException ae) {
            ae.printStackTrace();
            System.out.println(ae.getMessage());
        }
    }
    private Properties getProperties(){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", userName);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }
    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

}
