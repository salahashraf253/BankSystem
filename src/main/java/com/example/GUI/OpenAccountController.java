package com.example.GUI;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class OpenAccountController {

    @FXML
    AnchorPane open_account_pane;

    @FXML
    void closeWindow() {
        open_account_pane.setVisible(false);
    }
}
