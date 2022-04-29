package com.example.dataBase.Functions;

import com.example.Decorator.DecryptStringProvider;
import com.example.Decorator.PlainStringProvider;
import com.example.Decorator.StringProvider;

public class DecryptString {
    public static String getDecrptString(String valueToDecrpt){
        StringProvider decryptedValue = new DecryptStringProvider(new PlainStringProvider(valueToDecrpt));
        return decryptedValue.getStringValue();
    }
}
