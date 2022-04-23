package com.example.GUI;

import com.example.banksystem.MainClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

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
}
