package com.example.GUI;
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

public class LoanWindowController implements Initializable {
    public String loanSelected;
    public int NumOfMonths ;
    public int LoanAmount ;
    @FXML
    AnchorPane loan_pane;
    @FXML
    private ComboBox LoanType;
    @FXML
    private TextField Amount;
    @FXML
    private TextField NumOfMonth;


    void select(ActionEvent event) {
        loanSelected = LoanType.getSelectionModel().getSelectedItem().toString();
        LoanAmount= Integer.parseInt(Amount.getText());
        NumOfMonths= Integer.parseInt(NumOfMonth.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list= FXCollections.observableArrayList("Educational","Home","Personal");
        LoanType.setItems(list);
    }
}