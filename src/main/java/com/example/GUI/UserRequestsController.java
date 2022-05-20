package com.example.GUI;

import com.example.Loan.Loan.Loan;
import com.example.Loan.LoanIterator.Iterator;
import com.example.Loan.LoanIterator.LoanRequestsRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserRequestsController implements Initializable {

    @FXML
    private TableView<Loan> loan_req_table;
    @FXML
    private TableColumn<Loan, Integer> account_col;
    @FXML
    private TableColumn<Loan, Integer> loan_id_col;
    @FXML
    private TableColumn<Loan, String> type_col;
    @FXML
    private TableColumn<Loan, LocalDate> start_col;
    @FXML
    private TableColumn<Loan, String> status_col;

    ObservableList<Loan> list = FXCollections.observableArrayList();

    public void initCol(){
        account_col.setCellValueFactory(new PropertyValueFactory<>("userId"));
        loan_id_col.setCellValueFactory(new PropertyValueFactory<>("loanId"));
        type_col.setCellValueFactory(new PropertyValueFactory<>("loanType"));
        start_col.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    public void loadRequests(){
        LoanRequestsRepo requestsRepo = new LoanRequestsRepo();
        for(Iterator iter = requestsRepo.getIterator(); iter.hasNext();)
        {
            Loan loan = (Loan) iter.next();
            list.add(loan);
        }
        loan_req_table.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        loadRequests();
    }
}
