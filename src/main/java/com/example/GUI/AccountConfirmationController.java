package com.example.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountConfirmationController implements Initializable {
    @FXML
    AnchorPane confirm_pane;

    PageLoader pageLoader = new PageLoader();

    @FXML
    void confirmBtn(){
        pageLoader.closePage(confirm_pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
