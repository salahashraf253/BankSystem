package com.example.Generator;

import com.example.dataBase.Functions.DataBaseReader;

import java.sql.SQLException;

/*
we have to generate two Strings
 temp password for forget password option
authentication  code for sign up option
* */
public interface Generator {
    int generate(generator whatToGenerate) throws SQLException;
    DataBaseReader dataBaseReader = new DataBaseReader();
    enum generator{
        user_id,
        account_id,
        transaction_id,
        loan_id,
    }
}
