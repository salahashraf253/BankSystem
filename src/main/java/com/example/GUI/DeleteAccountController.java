package com.example.GUI;

import com.example.dataBase.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAccountController {
    @FXML
    private TextField text_AccId;
    PreparedStatement ps=null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public void Delete_Account() throws SQLException {
        Connection con= DataBase.getConnection();
        ps=con.prepareStatement("delete from bank_account where account_id=?");
        ps.setString(1,text_AccId.getText());
        ps.execute();
        con.close();
        alert.setContentText("Account is updated successfully");
        alert.show();
    }
}
