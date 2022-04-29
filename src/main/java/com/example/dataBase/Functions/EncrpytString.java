package com.example.dataBase.Functions;

import com.example.Decorator.EncryptStringProvider;
import com.example.Decorator.PlainStringProvider;
import com.example.Decorator.StringProvider;

public class EncrpytString {
    public static String getEncrpytedString(String valueToEncrpyt){
        StringProvider encryptedValue = new EncryptStringProvider(new PlainStringProvider(valueToEncrpyt));
        return encryptedValue.getStringValue();
    }
}
