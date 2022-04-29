package com.example.Decorator;

public class StringProviderDecorator implements StringProvider{
    protected StringProvider delegate;
    public StringProviderDecorator(StringProvider delegate) {
        this.delegate = delegate;
    }
    @Override
    public String getStringValue() {
        return this.delegate.getStringValue();
    }

}
