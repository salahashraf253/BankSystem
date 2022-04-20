package com.example.UserFactory;

public class FactoryUser {

    public User getUserType (String userType, String pos) {
        // this is supposed to be in a form of combobox-ish
        if (userType==null)
        {
            return null;
        }
        if (userType.equalsIgnoreCase("staff")) {
            Staff staff= new Staff();
            staff.setPosition (pos);
            return staff ;
        } else if (userType.equalsIgnoreCase("client")) {
           return new Client();
        }
        return null;
    }

}
