package com.example.GUI;

import com.example.Loan.Loan.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LoanApplicationController implements Initializable {
    @FXML
    AnchorPane loan_pane;
    @FXML
    private ComboBox <String>LoanType;
    @FXML
    private ComboBox<String>NumOfMonth;
    @FXML
    private TextField Amount;

    private String loanSelected;
    private int numOfMonths;
    private int loanAmount;

    void getLoanAttributes() {
        loanSelected = LoanType.getValue();
        loanAmount = Integer.parseInt(Amount.getText());
        numOfMonths = Integer.parseInt(NumOfMonth.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> typeList = FXCollections.observableArrayList("Educational", "Home", "Personal");
        LoanType.setItems(typeList);
        ObservableList<String> Months = FXCollections.observableArrayList("6", "12");
        NumOfMonth.setItems(Months);
    }

    public void applyForLoan(ActionEvent actionEvent) {
        try{
            getLoanAttributes();
            Loan loan=LoanFactory.getLoan(loanSelected);
            loan.setAmount(loanAmount);
            loan.setUser(LayoutController.user);
            loan.setLoanType(loanSelected);
            loan.setRepaymentPeriod(numOfMonths);
            LocalDate dateNow=LocalDate.now();
            loan.setStartDate(Date.valueOf(dateNow));
            loan.setEndDate(java.sql.Date.valueOf(dateNow.plusMonths(numOfMonths)));
            loan.ApplyForLoan();
        }
        catch (Exception exception){
            System.out.println("Error in apply for loan");
            System.out.println(exception.getMessage());
        }
    }
}
