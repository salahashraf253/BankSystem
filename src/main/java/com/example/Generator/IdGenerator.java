package com.example.Generator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class IdGenerator implements Generator{

    private String getNameOfTable(generator whatToGenerate){
        return switch (whatToGenerate) {
            case user_id -> "user"; //this names of table in Database
            case account_id -> "bank_account";
            case transaction_id -> "transaction";
        };
    }

    @Override
    public int generate(generator whatToGenerate) throws SQLException {
        String query="select count(*) from ";
        query+= getNameOfTable(whatToGenerate) +" ;";
        ResultSet resultSet=dataBaseReader.read(query);
        if(resultSet.next()){
            int ctr= resultSet.getInt(1);
            System.out.println("Ctr : "+ctr);
            return (ctr+1);
        }
        System.out.println("Error in ID Generator");
        return 0;
    }

}
