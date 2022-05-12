package com.example.GUI;

import com.example.banksystem.Account.Account;
import com.example.banksystem.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AccountHistoryController implements Initializable {
    @FXML
    private TableView<Transaction> history_table;
    @FXML
    private TableColumn<Transaction, Integer> trans_col;
    @FXML
    private TableColumn<Transaction, Float> amount_col;
    @FXML
    private TableColumn<Transaction, Date> date_col;
    @FXML
    private TableColumn<Transaction,String> status_col;

    ObservableList<Transaction> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            initCol();
            loadTransactions();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void initCol(){
        trans_col.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("transactionID"));
        amount_col.setCellValueFactory(new PropertyValueFactory<Transaction, Float>("amount"));
        date_col.setCellValueFactory(new PropertyValueFactory<Transaction, Date>("date"));
        status_col.setCellValueFactory(new PropertyValueFactory<Transaction,String>("type"));
    }
    public void loadTransactions(){
       try{
            list= Transaction.getTransactions(4123);
            history_table.setItems(list);
        }
        catch (Exception e){
            System.out.println("Error in Account history controller");
            System.out.println(e.getMessage());
        }
    }
}
