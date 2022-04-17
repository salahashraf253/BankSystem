package com.example.notification;


public class AuthenticationEmail extends Email {


    String sendAuthenticationEmail(String recipient){
        int maxRandomNumber = 100000000;
        int minRandomNumber = 1000000;
        int authenticationCode =(int)Math.floor(Math.random()*(maxRandomNumber - minRandomNumber +1)+ minRandomNumber);
        String subject="2-Factor Authentication ASU Bank";
        String body="<font size=+2>"+
                "<p style="+fontType+">"+
                "<b>Hello!</b><br>Your 2-Factor Authentication code is \""
                +Integer.toString(authenticationCode)+
                "\"</p></font>";
        super.sendFromGMail(recipient,subject,body);

        //return the authentication code that was sent to the user to validate it
        return Integer.toString(authenticationCode);
    }

    //Test the API
    public static void main(String []args){
        AuthenticationEmail authenticationEmail=new AuthenticationEmail();
        String recipient="username@gmail.com";
        String authenicationCode=authenticationEmail.sendAuthenticationEmail(recipient);
    }
}
