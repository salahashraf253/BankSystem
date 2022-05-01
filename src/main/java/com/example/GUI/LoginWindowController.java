package com.example.GUI;

import com.example.UserFactory.User;
import com.example.banksystem.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginWindowController {
    @FXML
    AnchorPane login_pane;
    @FXML
    TextField id;
    @FXML
    TextField password;
    @FXML
    void closeWindow() {
        login_pane.setVisible(false);
    }

    @FXML
    void loginButton() throws SQLException {
        User user=Login.validateLogin(id.getText(),password.getText());
        if(user==null){
            return; //invalid user id or password
        }
        String emailBody="You have just logged in";
//        user.notifyUser("ASU Bank Security alert",emailBody);
        /*use multi threading here */
        //to send the notifier email in parallel with another functions
        //because sending the email take around 1 minute that is very bad for the performance
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable callMultiply = () -> user.notifyUser("ASU Bank Security alert",emailBody);
        executor.execute(callMultiply);
        executor.execute(() -> System.out.println("Hello in multi thread"));
        executor.shutdown();
    }
}
