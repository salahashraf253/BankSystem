package com.example.Generator;

import com.example.dataBase.Functions.DataBaseReader;
import com.example.dataBase.Functions.DataBaseWriter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountIDGenerator implements Generator{
    @Override
    public String build() throws SQLException {
        String query="select * from bank_account;";
        ResultSet resultSet= dataBaseReader.read(query);
        if(resultSet.next()){
            int numOfAccounts= resultSet.getInt(1);
            return Integer.toString(++numOfAccounts);
        }
        return null;
    }
}
