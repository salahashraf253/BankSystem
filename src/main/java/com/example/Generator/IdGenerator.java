package com.example.Generator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IdGenerator implements Generator{

    private String getNameOfTable(generator whatToGenerate){
        return switch (whatToGenerate) {
            case user_id -> "user"; //this names of table in Database
            case account_id -> "bank_account";
            case transaction_id -> "transaction";
        };
    }

    @Override
    public String generate(generator whatToGenerate) throws SQLException {
        String query="select count(*) from ";
        query+= getNameOfTable(whatToGenerate) +" ;";
        ResultSet resultSet=dataBaseReader.read(query);
        String id= "";
        if(resultSet.next()){
            int numOfUsers= resultSet.getInt(1);
            id=Integer.toString(++numOfUsers);
        }
        return id;
    }

}
