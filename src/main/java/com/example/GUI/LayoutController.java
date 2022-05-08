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

public class LayoutController implements Initializable {
    @FXML
    BorderPane main_pane;
    @FXML
    private StackPane center_pane;
    @FXML
    public AnchorPane welcome_pane,login_pane,currency_conv_pane,open_account_pane;
    @FXML
    protected JFXButton login_btn, currency_conv_btn;

    PageLoader pageLoader = new PageLoader();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       login_pane.setVisible(false);
       open_account_pane.setVisible(false);
       currency_conv_pane.setVisible(false);
    }
    @FXML
    public void login() {
        login_pane.setVisible(true);
    }
    @FXML
    public void openAccountForm() {
        open_account_pane.setVisible(true);
    }
    @FXML
    public void currency_conv_btn(ActionEvent actionEvent) {
        if(currency_conv_btn.getTextFill().toString().equalsIgnoreCase("0xfafafaff")) {
            currency_conv_pane.setVisible(false);
            currency_conv_btn.setTextFill(Paint.valueOf("#ffffff"));
        }
        else {
            currency_conv_pane.setVisible(true);
            currency_conv_btn.setTextFill(Paint.valueOf("#fafafa"));
        }
    }

    /*public void openForm(String url){
        center_pane.getChildren().clear();
        center_pane.getChildren().setAll(pageLoader.getPage(url));
    }*/
}
