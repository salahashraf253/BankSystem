package com.example.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable {
    @FXML
    private LoginWindowController loginWindowController;
    @FXML
    AnchorPane welcome_pane;
    @FXML
    AnchorPane login_pane;
    @FXML
    AnchorPane open_account_pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_pane.setVisible(false);
        open_account_pane.setVisible(false);
    }
    void loadWindow(String loc, String title, Boolean max) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.setMaximized(max);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void login() {
        open_account_pane.setVisible(false);
        login_pane.setVisible(true);
    }
    @FXML
    public void openAccountForm() {
        login_pane.setVisible(false);
        open_account_pane.setVisible(true);
    }
}
