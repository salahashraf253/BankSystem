package com.example.GUI;

import com.example.UserFactory.Client;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.GUI.LayoutController.user;

public class SettingsController implements Initializable {
    @FXML
    private Label acc_type_lbl, acc_num_lbl;
    @FXML
    private TextField name_txt, gender_txt, dob_txt, id_txt, marital_txt, occupation_txt, income_txt;
    @FXML
    private TextField address_txt, email_txt, phone_txt;
    @FXML
    private Client client=(Client) user;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserData();
    }
    void loadUserData(){
        try{
            System.out.println("Name: "+ user.getFirstName());
//            name_lbl.setText(LayoutController.user.getFirstname());
            Platform.runLater(() -> {
                String accountNumber= String.valueOf(client.getAccount().getAccount_no());
                acc_num_lbl.setText(accountNumber);
                acc_type_lbl.setText(client.getAccount().getAccountType());
                name_txt.setText(client.getFirstName());
                gender_txt.setText(client.getGender());
                dob_txt.setText(String.valueOf(client.getDob()));
                id_txt.setText(String.valueOf(client.getSSN()));
                income_txt.setText(String.valueOf(client.getSalary()));
                marital_txt.setText(client.getStatus());
                address_txt.setText(client.getAddress());
                email_txt.setText(client.getEmail());
                phone_txt.setText(client.getPhoneNumber());
            });
        }
        catch (Exception e){
            System.out.println("Error in home controller");
            System.out.println(e.getMessage());
        }
    }

}
