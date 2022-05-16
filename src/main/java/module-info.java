module com.example.banksystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    requires java.mail;
    requires javax.activation;
    requires org.json;
    requires com.jfoenix;
    requires org.controlsfx.controls;
    requires TrayTester;


    opens com.example.banksystem to javafx.fxml;
    exports com.example.banksystem;
    exports com.example.GUI;
    exports com.example.banksystem.Account;
    opens com.example.banksystem.Account to javafx.fxml;
    opens com.example.GUI to javafx.fxml;
    exports com.example.banksystem.Account;
    opens com.example.banksystem.Account to javafx.fxml;

}