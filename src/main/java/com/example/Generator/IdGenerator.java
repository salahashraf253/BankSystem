package com.example.Generator;

import com.example.dataBase.Functions.DataBaseReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IdGenerator implements Generator{

    @Override
    public String build() throws SQLException {
        String query="select count(*) from user;";
        ResultSet resultSet=dataBaseReader.read(query);
        String id= "";
        if(resultSet.next()){
            int numOfUsers= resultSet.getInt(1);
            id=Integer.toString(++numOfUsers);
        }
        return id;
    }

}
