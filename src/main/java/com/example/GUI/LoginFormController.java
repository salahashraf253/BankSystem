package com.example.GUI;

import com.example.UserFactory.User;
import com.example.banksystem.Login;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginFormController {
    @FXML
    AnchorPane login_pane;
    @FXML
    private TextField id_txt, password_txt;
    @FXML
    private JFXButton login_btn;
    @FXML
    private Label incorrect_userId , incorrect_password;


    PageLoader pageLoader = new PageLoader();

    @FXML
    void closeForm() {
        login_pane.setVisible(false);
    }

    @FXML
    void login() throws SQLException {
        User user= Login.validateLogin(id_txt.getText(),password_txt.getText());
        if(user==null){
            incorrect_password.setVisible(true);
            incorrect_userId.setVisible(true);
            return; //invalid user id or password
        }
        String emailBody="You have just logged in";
//        user.notifyUser("ASU Bank Security alert",emailBody);
        /*use multi threading here */
        //to send the notifier email in parallel with another functions
        //because sending the email take around 1 minute that is very bad for the performance
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Runnable callMultiply = () -> user.notifyUser("ASU Bank Security alert",emailBody);
//        executor.execute(callMultiply);
//        Runnable openAccountForm= () ->pageLoader.loadPage("/com/example/banksystem/AccountLayout.fxml",
//                "EDB", true, true);
//        executor.execute(openAccountForm);
////        Runnable closeCurrentForm=()->pageLoader.closePage(login_pane);
////        executor.execute(closeCurrentForm);
//        executor.shutdown();
//        System.out.println("It is working ");
//        pageLoader.closePage(login_pane);
//        user.notifyUser("ASU Bank Security alert",emailBody);
        LayoutController.user=user;
        pageLoader.loadPage("/com/example/banksystem/AccountLayout.fxml","EDB",true, true);
        pageLoader.closePage(login_pane);
//        user.notifyUser("ASU Bank Security alert",emailBody);
    }
}
