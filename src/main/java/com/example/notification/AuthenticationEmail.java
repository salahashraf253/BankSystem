package com.example.notification;


import com.example.Generator.Generator;
import com.example.Generator.IdGenerator;
import com.example.Generator.PasswordGenerator;

import java.sql.SQLException;

public class AuthenticationEmail extends Email {

    public String [] sendAuthenticationEmail(String recipient) throws SQLException {
        IdGenerator idGenerator=new IdGenerator();
        String id=Integer.toString(idGenerator.generate(Generator.generator.user_id));
        String password=PasswordGenerator.generatePassword();
        String emailBody="<font size=+2>"+
                "<p style="+fontType+">"+
                "<b>Hello!</b>" +
                "<br>" +
                "Your ID is \""
                +id+
                "\" and password is \"" +password+
                "\".</p>" +
                "<p>Please don't share this email with anyone.</p></font>";
        super.setEmailBody(emailBody);
        super.setEmailSubject("ASU Bank authentication Email");
        super.sendEmail(recipient);
        String data[]=new String[2];
        data[0]=id;
        data[1]=password;
        return data;
    }

    //Test the API
    public static void main(String []args) throws SQLException {
        AuthenticationEmail authenticationEmail=new AuthenticationEmail();
//        String recipient="salmamagdyishakk@gmail.com";
        String recipient="salahashraf924@gmail.com";
        PasswordGenerator passwordGenerator=new PasswordGenerator();
        IdGenerator idGenerator=new IdGenerator();
//        authenticationEmail.sendAuthenticationEmail(recipient,idGenerator.build(),passwordGenerator.build());
    }
}
