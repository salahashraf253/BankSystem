package com.example.Generator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//reference : https://mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/

public class PasswordValidator {
    private static final String passwordPattern =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern pattern = Pattern.compile(passwordPattern);

    public static boolean isValid(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    //Test Class PasswordValidator
    public static void main(String []args){
        System.out.println(PasswordValidator.isValid("1234p5K*"));
        System.out.println(PasswordValidator.isValid("123456789*"));

    }
}
//Password rules
//contain at least one digit [0-9].
//contain at least one lowercase Latin character [a-z].
//contain at least one uppercase Latin character [A-Z].
//contain at least one special character like ! @ # & ( ).
//contain a length of at least 8 characters and a maximum of 20 characters.