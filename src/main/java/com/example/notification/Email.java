package com.example.notification;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public abstract class Email {
    private final String userName = "username";  // GMail user name (just the part before "@gmail.com")
    private final String password = "***********"; // GMail password
    private final String host = "smtp.gmail.com";
    protected String fontSize="font-size:20px";
    protected String fontType="font-family:'Times New Roman'";

    public void sendFromGMail(String recipient, String subject, String body) {
        String []to={recipient};

        Properties props=buildProperties();
        Session session = Session.getDefaultInstance(props);
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

            message.setSubject(subject);
            message.setContent(body,"text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, userName, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException ae) {
            ae.printStackTrace();
            System.out.println(ae.getMessage());
        }
    }

    private Properties buildProperties(){
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", userName);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        return props;
    }
}
