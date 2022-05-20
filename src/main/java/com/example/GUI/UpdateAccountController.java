package com.example.GUI;

import com.example.dataBase.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateAccountController {
    @FXML
    private TextField text_AccId;

    @FXML
    private TextField text_balance;

    @FXML
    private TextField text_type;

    @FXML
    private TextField text_userid;
    
    PreparedStatement ps=null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public void Update_Account() throws SQLException {
        DataBase db=DataBase.getDataBaseInstance();
        Statement statement= db.getConnection().createStatement();
//        ps=con.prepareStatement("update bank_account where account_id=? set balance=?,type=?");
//
//        ps.setString(3,text_balance.getText());
//        ps.setString(4,text_type.getText());
//        ps.execute();
//        con.close();
//
//        alert.setContentText("Account is updated successfully");
//        alert.show();
    }
}
