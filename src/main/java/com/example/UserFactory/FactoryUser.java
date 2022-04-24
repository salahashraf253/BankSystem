package com.example.UserFactory;

public class FactoryUser {

    public User getUserType (String userType) {
        // this is supposed to be in a form of combobox-ish

        if (userType.equalsIgnoreCase("s")) {   //s for staff
            return new Staff();
        } else if (userType.equalsIgnoreCase("c")) { //c for client
           return new Client();
        }
        return null;
    }

}
