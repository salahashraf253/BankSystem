package com.example.UserFactory;

public class Staff extends User{

    String position;
 /*   public UserFactory.Staff(String name, int SSD, int phonenumber, Date dob, String password, String username, String address, String position) {
        super(name, SSD, phonenumber, dob, password, username, address);
        setPosition(position);
    }*/

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public void CreateUser(User user) {
        //in database mara wa7da
        // like UserFactory.Staff (user.name ,user.ssd , ...etc)
        //insert into staff values
        System.out.println("here in staff");

    }

}
