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
    private TableColumn<Transaction, Float> amount_col;
    @FXML
    private TableColumn<Transaction, Date> date_col;
    @FXML
    private TableView history_table;
    @FXML
    private TableColumn<Transaction,String> status_col;
    @FXML
    private TableColumn<Transaction, Integer> trans_col;

//    ObservableList list = FXCollections.observableArrayList();
    ObservableList<Transaction> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            trans_col.setCellValueFactory(new PropertyValueFactory<>("transactionID") );
            amount_col.setCellValueFactory(new PropertyValueFactory<>("amount") );
            date_col.setCellValueFactory(new PropertyValueFactory<>("date") );
            status_col.setCellValueFactory(new PropertyValueFactory<>("type") );
//            history_table.getColumns().setAll(trans_col,amount_col,date_col,status_col);
            loadTransactions();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void loadTransactions(){
//        try{
//            list= Transaction.getTransactions(4123);
//            System.out.println("Size of list is "+list.size());
//            history_table.setItems(list);
//        }
//        catch (Exception e){
//            System.out.println("Error in Account history controller");
//            System.out.println(e.getMessage());
//        }

        list.add(new Transaction(1312,1000,"1-1-2001","withdraw"));
        history_table.setItems(list);
    }
}
