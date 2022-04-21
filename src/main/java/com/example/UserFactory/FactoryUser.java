package com.example.UserFactory;

public class FactoryUser {

    public User getUserType (String userType) {
        // this is supposed to be in a form of combobox-ish
        if (userType==null)
        {
            return null;
        }
        if (userType.equalsIgnoreCase("staff")) {
            return new Staff();
        } else if (userType.equalsIgnoreCase("client")) {
           return new Client();
        }
        return null;
    }

}
