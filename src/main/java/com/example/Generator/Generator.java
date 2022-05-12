package com.example.Generator;

import com.example.dataBase.Functions.DataBaseReader;

import java.sql.SQLException;

/*
we have to generate two Strings
 temp password for forget password option
authentication  code for sign up option
* */
public interface Generator {
    String build() throws SQLException;
    DataBaseReader dataBaseReader = new DataBaseReader();
}
