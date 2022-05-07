package com.example.GUI;

import com.example.banksystem.Account.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountHistoryController implements Initializable {
    @FXML
    private TableColumn amount_col;

    @FXML
    private TableColumn date_col;

    @FXML
    private TableView history_table;

    @FXML
    private TableColumn status_col;

    @FXML
    private TableColumn trans_col;
    ObservableList list = FXCollections.observableArrayList();

    public ObservableList getTransaction(){
        // add transaction table where online account id in this list
        return list;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trans_col.setCellValueFactory(new PropertyValueFactory<>("transaction_id") );
        amount_col.setCellValueFactory(new PropertyValueFactory<>("amount") );
        date_col.setCellValueFactory(new PropertyValueFactory<>("date") );
        status_col.setCellValueFactory(new PropertyValueFactory<>("status") );
    }
}
