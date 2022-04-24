package com.example.GUI;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import com.example.GUI.*;

public class OpenAccountController {
    protected LayoutController layoutController;
    @FXML
    AnchorPane open_account_pane;

    @FXML
    void closeWindow() {
        open_account_pane.setVisible(false);
    }
}
