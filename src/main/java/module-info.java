module com.example.banksystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.banksystem to javafx.fxml;
    exports com.example.banksystem;
    exports com.example.GUI;
    opens com.example.GUI to javafx.fxml;
}