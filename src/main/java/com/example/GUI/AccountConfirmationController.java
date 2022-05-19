package com.example.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountConfirmationController implements Initializable {
    @FXML
    AnchorPane confirm_pane;
    @FXML
    private static Label first_lbl;
    @FXML
    private static Label second_lbl;
    PageLoader pageLoader = new PageLoader();

    @FXML
    void confirmBtn(){
        pageLoader.closePage(confirm_pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public static void setMessage(String message1,String message2){
        first_lbl.setText(message1);
        second_lbl.setText(message2);
    }
}
