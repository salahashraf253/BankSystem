package com.example.GUI;

import com.example.LoanPackage.Loan.Loan;
import com.example.LoanPackage.LoanIterator.Iterator;
import com.example.LoanPackage.LoanIterator.LoanRequestsRepo;
import com.example.NotificationsObserver.DesktopNotificationBuilder;
import com.example.dataBase.Functions.DataBaseReader;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import tray.notification.NotificationType;

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
    private TableColumn<Loan, Float> monthlyPaid;
    @FXML
    private TableColumn<Loan, Void> approve_col;
    @FXML
    private TableColumn<Loan, Void> reject_col;

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
        monthlyPaid.setCellValueFactory(new PropertyValueFactory<>("monthlyInstallment"));
        addApproveBtnToTable();
        addRejectBtnToTable();
    }
    private void addApproveBtnToTable(){
        Callback<TableColumn<Loan, Void>, TableCell<Loan, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Loan, Void> call(final TableColumn<Loan, Void> param) {
                final TableCell<Loan, Void> cell = new TableCell<>() {
                    private final JFXButton approveBtn = new JFXButton("  Approve  ");{
                        approveBtn.setStyle("-fx-background-color: #003366");
                        approveBtn.setOnAction((ActionEvent event) -> {
                            Loan loan = loan_req_table.getSelectionModel().getSelectedItem();
                            int loanId = 0;
                            try {
                                loanId = loan.getLoanId();
                            }
                            catch (Exception e){
                                DesktopNotificationBuilder.notifyUser("Please select the row First", NotificationType.ERROR);
                            }
                            DataBaseReader dbr = new DataBaseReader();
                            try {
                                String query ="update loan set status ='"+"Approved"+"' where loan_id='"+loanId+"';";
                                dbr.updateDatabase(query);
                                loadRequests();
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(approveBtn);
                        }
                    }
                };
                return cell;
            }
        };
        approve_col.setCellFactory(cellFactory);
    }
    private void addRejectBtnToTable(){
        Callback<TableColumn<Loan, Void>, TableCell<Loan, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Loan, Void> call(final TableColumn<Loan, Void> param) {
                final TableCell<Loan, Void> cell = new TableCell<>() {
                    private final JFXButton rejectBtn = new JFXButton("   Reject   ");{
                        rejectBtn.setStyle("-fx-background-color: #003366");
                        rejectBtn.setOnAction((ActionEvent event) -> {
                            Loan loan = loan_req_table.getSelectionModel().getSelectedItem();
                            int loanId = 0;
                            try {
                                loanId = loan.getLoanId();
                            }
                            catch (Exception e){
                                DesktopNotificationBuilder.notifyUser("Please select the row First", NotificationType.ERROR);
                            }
                            DataBaseReader dbr = new DataBaseReader();
                            try {
                                String query ="update loan set status ='"+"Rejected"+"' where loan_id='"+loanId+"';";
                                dbr.updateDatabase(query);
                                loadRequests();
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(rejectBtn);
                        }
                    }
                };
                return cell;
            }
        };
        reject_col.setCellFactory(cellFactory);
    }
    public void clearTableView(){
        for ( int i = 0; i<loan_req_table.getItems().size(); i++) {
            loan_req_table.getItems().clear();
        }
    }
    public void loadRequests() throws SQLException {
        clearTableView();
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
