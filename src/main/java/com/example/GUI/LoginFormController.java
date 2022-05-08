package com.example.GUI;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginFormController {
    @FXML
    AnchorPane login_pane;
    @FXML
    private JFXButton login_btn;

    PageLoader pageLoader = new PageLoader();

    @FXML
    void closeForm() {
        login_pane.setVisible(false);
    }

    @FXML
    void login() {
        pageLoader.loadPage("/com/example/banksystem/AccountLayout.fxml","EDB",true, true);
        pageLoader.closePage(login_pane);
    }
}
