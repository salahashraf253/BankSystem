module com.example.banksystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;
    requires javax.activation;
    requires org.json;
    requires com.jfoenix;


    opens com.example.banksystem to javafx.fxml;
    exports com.example.banksystem;
    exports com.example.GUI;
    opens com.example.GUI to javafx.fxml;
}