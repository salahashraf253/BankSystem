package com.example.GUI;

import com.example.dataBase.DataBase;
import com.example.dataBase.Functions.DataBaseReader;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import  com.example.banksystem.Account.Account;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewAccountController implements Initializable {

    @FXML
    private TableView<Account> AccountTable;

    @FXML
    private TableColumn<Account, Integer> BalanceCol;

    @FXML
    private TableColumn<Account, Integer> IdCol;

    @FXML
    private TableColumn<Account, String> TypeCol;

    @FXML
    private TableColumn<Account, Integer> UserIdCol;
    @FXML
    private TextField text_AccId;

    @FXML
    private TextField text_balance;

    @FXML
    private TextField text_type;

    @FXML
    private TextField text_userid;
    DataBase db = null;
    ObservableList<Account> list = FXCollections.observableArrayList();
    public ObservableList<Account> getAccount() throws SQLException {
        DataBaseReader db = null;

        try {
           ResultSet rs=db.read("select * from bank_account");
            while (rs.next())
            {
              //
            }
        }

      catch (Exception e){

      }


        return list;
    }
    PreparedStatement ps=null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public void Add_Account() throws SQLException {
        Connection con=DataBase.getConnection();
        ps=con.prepareStatement("insert into bank_account (account_id,user_id,balance,type) values (?,?,?,?)");
        ps.setString(1,text_AccId.getText());
        ps.setString(2,text_userid.getText());
        ps.setString(3,text_balance.getText());
        ps.setString(4,text_type.getText());
        ps.execute();

        alert.setContentText("Account is Added successfully");
        alert.show();
    }
    public void Update_Account() throws SQLException {
        Connection con=DataBase.getConnection();
        ps=con.prepareStatement("update bank_account set account_id=?,user_id=?,balance=?,type=?");

        ps.setString(1,text_AccId.getText());
        ps.setString(2,text_userid.getText());
        ps.setString(3,text_balance.getText());
        ps.setString(4,text_type.getText());
        ps.execute();

        alert.setContentText("Account is updated successfully");
        alert.show();
    }

    public void Delete_Account() throws SQLException {
        Connection con=DataBase.getConnection();
        ps=con.prepareStatement("delete from bank_account where account_id=?");
        ps.setString(1,text_AccId.getText());
        ps.execute();
        alert.setContentText("Account is updated successfully");
        alert.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IdCol.setCellValueFactory(new PropertyValueFactory<Account,Integer>("Account_no") );
        UserIdCol.setCellValueFactory(new PropertyValueFactory<Account,Integer>("user_id") );
        BalanceCol.setCellValueFactory(new PropertyValueFactory<Account,Integer>("balance") );
        TypeCol.setCellValueFactory(new PropertyValueFactory<Account,String>("type") );

        AccountTable.setItems(list);
    }
}
