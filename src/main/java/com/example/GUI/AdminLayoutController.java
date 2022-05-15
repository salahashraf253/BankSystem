package com.example.GUI;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminLayoutController implements Initializable {
    @FXML
    AnchorPane root;
    @FXML
    BorderPane layout_pane;
    @FXML
    StackPane center_pane;
    @FXML
    private JFXButton login_btn, currency_conv_btn;
    PageLoader pageLoader = new PageLoader();

    @FXML
    public void currency_conv_btn(ActionEvent actionEvent) {
        center_pane.getChildren().clear();
        if(currency_conv_btn.getTextFill().toString().equalsIgnoreCase("0xfafafaff"))
            currency_conv_btn.setTextFill(Paint.valueOf("#ffffff"));
        else {
            center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/currency-converter.fxml"));
            currency_conv_btn.setTextFill(Paint.valueOf("#fafafa"));
        }
    }

    @FXML
    public void logout(ActionEvent actionEvent) {
        pageLoader.loadPage("/com/example/banksystem/Layout.fxml","EDB",true, true);
        pageLoader.closePage(root);
    }
    @FXML
    public void addAdmin() {
    }
    @FXML
    public void addNewAccount() {
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/OpenAccount.fxml"));
    }
    @FXML
    public void viewAccounts() {
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/ViewAccount.fxml"));
    }
    @FXML
    public void loanRequests() {
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/LoanRequests.fxml"));
    }
    @FXML
    public void adminSettings() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
