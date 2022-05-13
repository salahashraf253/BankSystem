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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LoanApplicationController implements Initializable {
    @FXML
    AnchorPane loan_pane;
    @FXML
    private ComboBox LoanType, NumOfMonth;
    @FXML
    private TextField Amount;

    public String loanSelected;
    public int numOfMonths;
    public int loanAmount;

    void select() {
        loanSelected = LoanType.getSelectionModel().getSelectedItem().toString();
        loanAmount = Integer.parseInt(Amount.getText());
        numOfMonths = (int) LoanType.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> typeList = FXCollections.observableArrayList("Educational", "Home", "Personal");
        LoanType.setItems(typeList);
        ObservableList<Integer> Months = FXCollections.observableArrayList(6, 12);
        NumOfMonth.setItems(Months);
    }


    public void applyButton() {
        // get AccountId of Current User
        Loan loan = LoanFactory.getLoan(loanSelected);
    }

    public void applyForLoan(ActionEvent actionEvent) {
    }
}
