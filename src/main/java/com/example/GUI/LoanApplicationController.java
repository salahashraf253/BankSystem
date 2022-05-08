package com.example.GUI;

import com.example.Loan.Loan.Loan;
import com.example.Loan.Loan.LoanFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoanApplicationController implements Initializable {
    public String loanSelected;
    public int NumOfMonths;
    public int LoanAmount;
    @FXML
    AnchorPane loan_pane;
    @FXML
    private ComboBox LoanType, NumOfMonth;
    @FXML
    private TextField Amount;


    void select() {
        loanSelected = LoanType.getSelectionModel().getSelectedItem().toString();
        LoanAmount = Integer.parseInt(Amount.getText());
        NumOfMonths = (int) LoanType.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> Typelist = FXCollections.observableArrayList("Educational", "Home", "Personal");
        LoanType.setItems(Typelist);
        ObservableList<Integer> Months = FXCollections.observableArrayList(6, 12);
        NumOfMonth.setItems(Months);
    }

    public void applyButton() {
        Loan loan = LoanFactory.getLoan(loanSelected);
    }

    public void applyForLoan(ActionEvent actionEvent) {
    }
}
