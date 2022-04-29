package com.example.Decorator;

public class DecoratorPatternTester {
    public static void main(String[] args) {

        String originalValue = "this is a test";

        StringProvider encryptedValue = new EncryptStringProvider(new PlainStringProvider(originalValue));
        String enc = encryptedValue.getStringValue();

        System.out.println(enc);

        StringProvider decryptedValue = new DecryptStringProvider(new PlainStringProvider(enc));
        String dec = decryptedValue.getStringValue();
        System.out.println(dec);

    }
}
