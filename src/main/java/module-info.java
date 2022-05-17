module com.example.banksystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;
    requires javax.activation;
    requires org.json;
    requires com.jfoenix;
    requires controlsfx;
    requires TrayTester;


    opens com.example.banksystem to javafx.fxml;
    exports com.example.banksystem;
    exports com.example.GUI;
    exports com.example.banksystem.Account;

    opens com.example.banksystem.Account to javafx.base, javafx.fxml;
    opens com.example.GUI to javafx.fxml;
}