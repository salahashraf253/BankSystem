package com.example.GUI;

import com.example.dataBase.DataBase;
import com.example.dataBase.Functions.DataBaseReader;
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
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewAccountController implements Initializable {

    PageLoader loader = new PageLoader();
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
    @FXML
    private AnchorPane center_pane;

    DataBase db = null;
    ObservableList<Account> list = FXCollections.observableArrayList();
    public ObservableList<Account> getAccount() throws SQLException {
        DataBaseReader db = null;

        try {
           ResultSet rs=db.read("select * from bank_account");
            while (rs.next())
            {

              //

//             list.add(new Account());

            }
        }

      catch (Exception e){

      }


        return list;
    }
    PreparedStatement ps=null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public void closeWindow(){
        center_pane.getChildren().removeAll();
    }
    public void Add_Account() {
        closeWindow();
        center_pane.getChildren().setAll(loader.getPage("/com/example/banksystem/AddAccount.fxml"));
    }

    public void Update_Account() throws SQLException {
        closeWindow();
        center_pane.getChildren().setAll(loader.getPage("/com/example/banksystem/Update Account.fxml"));
    }

    public void Delete_Account()  {
        closeWindow();
        center_pane.getChildren().setAll(loader.getPage("/com/example/banksystem/DeleteAccount.fxml"));
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
