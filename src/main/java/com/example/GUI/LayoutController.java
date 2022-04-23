package com.example.GUI;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable {
    @FXML
    private LoginWindowController loginWindowController;
    @FXML
    BorderPane main_pane;
    @FXML
    AnchorPane center_pane;
    @FXML
    AnchorPane welcome_pane;
    @FXML
    AnchorPane login_pane;
    @FXML
    AnchorPane open_account_pane;
    @FXML
    private JFXButton login_btn;

    PageLoader loader = new PageLoader();
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
        if(login_btn.getText().equalsIgnoreCase("Login")){
            center_pane.getChildren().removeAll();
            center_pane.getChildren().setAll(loader.getPage("/com/example/banksystem/LoginWindow.fxml"));
            //main_pane.setCenter(loader.getPage("/com/example/banksystem/LoginWindow.fxml"));
            login_btn.setText("Logout");
        }
        else if(login_btn.getText().equalsIgnoreCase("Logout")){
            center_pane.getChildren().removeAll();
            center_pane.getChildren().setAll(welcome_pane);
            // welcome_pane.setVisible(true);
            login_btn.setText("Login");
        }
    }
    @FXML
    public void openAccountForm() {
        // center_pane.getChildren().removeAll();
        closeWindow();
        center_pane.getChildren().setAll(loader.getPage("/com/example/banksystem/OpenAccount.fxml"));
        //login_pane.setVisible(false);
        // open_account_pane.setVisible(true);
    }
    public void closeWindow(){
        center_pane.getChildren().removeAll();
    }

    @FXML
    public void currency_conv_btn(ActionEvent actionEvent) {
        closeWindow();
        center_pane.getChildren().setAll(loader.getPage("/com/example/banksystem/currency-converter.fxml"));
    }
    /*@FXML
    public void login() {
        open_account_pane.setVisible(false);
        login_pane.setVisible(true);
    }
    @FXML
    public void openAccountForm() {
        login_pane.setVisible(false);
        open_account_pane.setVisible(true);
    }*/
}
