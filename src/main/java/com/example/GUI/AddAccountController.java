package com.example.GUI;

import com.example.dataBase.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddAccountController {
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
    public void Add_Account() throws SQLException {
        Connection con= DataBase.getConnection();
        ps=con.prepareStatement("insert into bank_account (account_id,user_id,balance,type) values (?,?,?,?)");
     //   ps.setString(1,text_AccId.getText());
       // ps.setString(2,text_userid.getText());
        ps.setString(3,text_balance.getText());
        ps.setString(4,text_type.getText());
        ps.execute();

        alert.setContentText("Account is Added successfully");
        alert.show();
        con.close();
    }

}
