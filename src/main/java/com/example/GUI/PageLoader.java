package com.example.GUI;

import com.example.banksystem.MainClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class PageLoader {

    private Pane view;
    public Pane getPage(String fileLocation){
        try {
            URL fileURL = MainClass.class.getResource(fileLocation);
            if (fileURL == null)
                throw new java.io.FileNotFoundException("FXML File Cannot be Found");
            view = new FXMLLoader().load(fileURL);
        }
        catch (Exception e){
            System.out.println("No Page Found at Location: "+ fileLocation);
        }
        return view;
    }

    public void loadPage(String loc, String title, Boolean max, Boolean Decorated) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage= new Stage();
            if(Decorated)
                stage.initStyle(StageStyle.DECORATED);
            else
                stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.setMaximized(max);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closePage(AnchorPane pane) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}
