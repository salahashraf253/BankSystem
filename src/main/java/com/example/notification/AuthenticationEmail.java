package com.example.notification;


public class AuthenticationEmail extends Email {

    String sendAuthenticationEmail(String recipient){
        int maxRandomNumber = 100000000;
        int minRandomNumber = 1000000;
        int randomNumber =(int)Math.floor(Math.random()*(maxRandomNumber - minRandomNumber +1)+ minRandomNumber);
        String subject="2-Factor Authentication ASU Bank";
        String body="<p style="+fontSize+">"+
                "<b>Hello!</b><br>Your 2-Factor Authentication code is \""
                +Integer.toString(randomNumber)+
                "\"</p>";
        super.sendFromGMail(recipient,subject,body);
        return Integer.toString(randomNumber);
    }

    //Test the API
    public static void main(String []args){
        AuthenticationEmail authenticationEmail=new AuthenticationEmail();
        String recipient="username@gmail.com";
        String authenicationCode=authenticationEmail.sendAuthenticationEmail(recipient);
    }
}
