module com.example.banksystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.banksystem to javafx.fxml;
    exports com.example.banksystem;
}