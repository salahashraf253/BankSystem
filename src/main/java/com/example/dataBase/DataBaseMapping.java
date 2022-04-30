package com.example.dataBase;
import com.example.UserFactory.FactoryUser;
import com.example.UserFactory.User;
import com.example.dataBase.Functions.DecryptString;
import java.sql.ResultSet;
import java.sql.SQLException;
/*this class is used for mapping objects for database row*/
public class DataBaseMapping {

    public static User getUser(ResultSet resultSet) throws SQLException {
        //this function take the result set as parameter
        //and return the user if found or null if not found
        try {
            if(resultSet.next()){
                String type=DecryptString.getDecrptString(resultSet.getString("type"));
                User user = FactoryUser.getUserType(type);
                System.out.println("type: "+type);
                assert user != null;
                user.setUserId(Integer.parseInt(DecryptString.getDecrptString(resultSet.getString("user_id"))));
                // Email
                user.setEmail(DecryptString.getDecrptString(resultSet.getString("email")));
                // Salary
                user.setSalary(Integer.parseInt(DecryptString.getDecrptString(resultSet.getString("salary"))));
                // First Name
                user.setFirstname(DecryptString.getDecrptString(resultSet.getString("firstName")));
                // Last Name
                user.setLastname(DecryptString.getDecrptString(resultSet.getString("lastName")));
                // Phone Number
                user.setPhonenumber(DecryptString.getDecrptString(resultSet.getString("phone")));
                //salary
                user.setSalary(Integer.parseInt(DecryptString.getDecrptString(resultSet.getString("salary"))));

                return user;
            }
            else{
                System.out.println("Invalid user Id or password");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;    //invalid user id or password
    }
}
