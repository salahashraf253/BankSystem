package com.example.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginWindowController {
    @FXML
    AnchorPane login_pane;
    @FXML
    void closeWindow() {
        login_pane.setVisible(false);
    }

}
