package com.example.GUI;

import com.example.Loan.Loan.Loan;
import com.example.Loan.LoanIterator.Iterator;
import com.example.Loan.LoanIterator.LoanRequestsRepo;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LoanRequestsController implements Initializable {
    @FXML
    private TableView<Loan> loan_req_table;
    @FXML
    private TableColumn<Loan, Integer> account_col;
    @FXML
    private TableColumn<Loan, Integer> loan_id_col;
    @FXML
    private TableColumn<Loan, String> type_col;
    @FXML
    private TableColumn<Loan, Integer> amount_col;
    @FXML
    private TableColumn<Loan, Float> month_col;
    @FXML
    private TableColumn<Loan, Double> rate_col;
    @FXML
    private TableColumn<Loan, LocalDate> start_col;
    @FXML
    private TableColumn<Loan, LocalDate> end_col;
    @FXML
    private TableColumn<Loan, String> status_col;
    @FXML
    private TableColumn<Loan, JFXButton> approve_col;
    @FXML
    private TableColumn<Loan, JFXButton> reject_col;

    ObservableList<Loan> list = FXCollections.observableArrayList();

    public void initCol(){
        account_col.setCellValueFactory(new PropertyValueFactory<>("userId"));
        loan_id_col.setCellValueFactory(new PropertyValueFactory<>("loanId"));
        type_col.setCellValueFactory(new PropertyValueFactory<>("loanType"));
        month_col.setCellValueFactory(new PropertyValueFactory<>("repaymentPeriod"));
        rate_col.setCellValueFactory(new PropertyValueFactory<>("rate"));
        amount_col.setCellValueFactory(new PropertyValueFactory<>("amount"));
        start_col.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        end_col.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        approve_col.setCellValueFactory(new PropertyValueFactory<>("approveBtn"));
        reject_col.setCellValueFactory(new PropertyValueFactory<>("rejectBtn"));
    }
    public void loadRequests() throws SQLException {
        //-1 means select all loans from database
        LoanRequestsRepo requestsRepo =new LoanRequestsRepo(-1);
        for(Iterator iter = requestsRepo.getIterator(); iter.hasNext();) {
            Loan loan = (Loan) iter.next();
            list.add(loan);
        }
        loan_req_table.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        try {
            loadRequests();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
