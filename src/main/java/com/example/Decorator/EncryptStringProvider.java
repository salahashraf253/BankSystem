package com.example.Decorator;

public class EncryptStringProvider extends StringProviderDecorator{


    public EncryptStringProvider(StringProvider delegate) {

        super(delegate);
    }

    @Override
    public String getStringValue(){

        return encryptString(delegate); //decorated
    }

    //Caesar Cipher Technique for Encryption
    public String encryptString(StringProvider aString){
        String encrypted_str = "";
        int len = aString.getStringValue().length();

        for(int i = 0; i < len; i++){
            char c = (char)(aString.getStringValue().charAt(i) + 3);
            if(c > 'z')
                encrypted_str += (char)(aString.getStringValue().charAt(i)) - (26-3);
            else
                encrypted_str += (char)(aString.getStringValue().charAt(i) + 3);
        }
        return encrypted_str;
    }

}
