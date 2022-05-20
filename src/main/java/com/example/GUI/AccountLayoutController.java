package com.example.GUI;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountLayoutController implements Initializable {
    @FXML
    AnchorPane root;
    @FXML
    BorderPane layout_pane;
    @FXML
    StackPane main_pane, center_pane;
    @FXML
    private JFXButton logout_btn, currency_conv_btn, home_btn;
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
    void home(){
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/Home.fxml"));
        try{
            System.out.println(LayoutController.user.getFirstname());
        }
        catch (Exception e){
            System.out.println("Error in Account layout controller");
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void moneyTransfer(){
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/MoneyTransfer.fxml"));
    }
    @FXML
    void history(){
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/AccountHistory.fxml"));
    }
    @FXML
    void balanceInquiry(){
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/BalanceInquiry.fxml"));
    }
    @FXML
    void applyForLoan(){
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/LoanApplication.fxml"));
    }
    @FXML
    public void viewRequests() {
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/UserRequests.fxml"));
    }
    @FXML
    void settings(){
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage("/com/example/banksystem/Settings.fxml"));
    }

    @FXML
    public void logout(ActionEvent actionEvent) {
        pageLoader.loadPage("/com/example/banksystem/Layout.fxml","EDB",true, true);
        pageLoader.closePage(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        home_btn.requestFocus();
        home_btn.applyCss();
        home();
    }

}
