package com.example.GUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoanWindowController implements Initializable {
    public String loanSelected;
    public int NumOfMonths;
    public int LoanAmount;
    @FXML
    AnchorPane loan_pane;
    @FXML
    private ComboBox LoanType;
    @FXML
    private TextField Amount;
    @FXML
    private ComboBox NumOfMonth;


    void select() {
        loanSelected = LoanType.getSelectionModel().getSelectedItem().toString();
        LoanAmount = Integer.parseInt(Amount.getText());
        NumOfMonths = (int) LoanType.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> Typelist = FXCollections.observableArrayList("Educational", "Home", "Personal");
        LoanType.setItems(Typelist);
        ObservableList<Integer> Months = FXCollections.observableArrayList(6, 12,18,24,36);
        NumOfMonth.setItems(Months);
    }

    public void applyButton() {
       // Loan loan = LoanFactory.getLoan(loanSelected);
    }
}