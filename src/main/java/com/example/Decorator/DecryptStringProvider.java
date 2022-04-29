package com.example.Decorator;

public class DecryptStringProvider extends StringProviderDecorator{
    public DecryptStringProvider(StringProvider delegate) {

        super(delegate);
    }
    @Override
    public String getStringValue(){

        return decryptString(delegate); //decorated
    }

    //Caesar Cipher Technique for Decryption
    public String decryptString(StringProvider aString){
        String Decrypted_str = "";
        int len = aString.getStringValue().length();
        for(int i = 0; i < len; i++){
            char c = (char)(aString.getStringValue().charAt(i) - 3);
            if(c > 'z')
                Decrypted_str += (char)(aString.getStringValue().charAt(i)) + (26+3);
            else
                Decrypted_str += (char)(aString.getStringValue().charAt(i) - 3);
        }
        return Decrypted_str;
    }
}
