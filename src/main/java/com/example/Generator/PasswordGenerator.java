package com.example.Generator;

//a --> 97 && z--> 126
//A --> 65 && Z--> 96

public class PasswordGenerator {

    public static String generatePassword() {
        StringBuilder password= new StringBuilder(generateRandomNumber());
        //add random symbol
        password.append(generateRandomSymbol());
        //add 2 random characters
        for(int i=0;i<2;i++){
            password.append(generateRandomCharacter());
        }
        return password.toString();
    }
    private static String generateRandomNumber(){
        int maxInteger = (int) 1e8;
        int minInteger = (int) 1e1;
        return Integer.toString((int)Math.floor(Math.random()*(maxInteger - minInteger +1)+ minInteger));
    }
    private static char generateRandomSymbol(){
        String symbols = "/*-+.!@#$%^&(){}|<>/';,~";
        int randomIndex=(int)Math.floor(Math.random()*(symbols.length()+1)+0);
        return symbols.charAt(randomIndex);
    }
    private static char generateRandomCharacter(){
        //a --> 97 && z--> 126
        //A --> 65 && Z--> 96
        int randomAscii=(int)Math.floor(Math.random()*(126-65+1)+65);
        return (char)(randomAscii);
    }
}


