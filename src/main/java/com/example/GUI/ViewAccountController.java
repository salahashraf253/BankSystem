package com.example.GUI;

import com.example.banksystem.Account.FactoryAccount;
import com.example.dataBase.DataBase;
import com.example.dataBase.DataBaseMapping;
import com.example.dataBase.Functions.DataBaseReader;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import  com.example.banksystem.Account.Account;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewAccountController implements Initializable {

    PageLoader loader = new PageLoader();
    @FXML
    private TableView<Account> accounts_table;
    @FXML
    private TableColumn<Account, Integer> account_id_col;
    @FXML
    private TableColumn<Account, Integer> user_id_col;
    @FXML
    private TableColumn<Account, String> type_col;
    @FXML
    private TableColumn<Account, Integer> balance_col;
    @FXML
    private TableColumn<Account, JFXButton> update_col;
    @FXML
    private TableColumn<Account, JFXButton> delete_col;

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



    PreparedStatement ps=null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

  /*  public void Update_Account() throws SQLException {
        center_pane.getChildren().setAll(loader.getPage("/com/example/banksystem/Update Account.fxml"));
    }

    public void Delete_Account()  {
        center_pane.getChildren().setAll(loader.getPage("/com/example/banksystem/DeleteAccount.fxml"));
    }*/

    public void InitCol(){
        account_id_col.setCellValueFactory(new PropertyValueFactory<>("account_no") );
        user_id_col.setCellValueFactory(new PropertyValueFactory<>("user_id") );
        balance_col.setCellValueFactory(new PropertyValueFactory<>("balance") );
        type_col.setCellValueFactory(new PropertyValueFactory<>("accountType") );
        update_col.setCellValueFactory(new PropertyValueFactory<>("updateBtn") );
        delete_col.setCellValueFactory(new PropertyValueFactory<>("deleteBtn") );
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InitCol();
        try {
            ObservableList<Account> list =DataBaseMapping.getAccounts();
            accounts_table.setItems(list);
        } catch (SQLException e) {

            System.out.println("Error in view account controller");
            System.out.println(e.getMessage());
        }

    }
}
