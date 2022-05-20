package com.example.GUI;


import com.example.Generator.Generator;
import com.example.Generator.IdGenerator;
import com.example.UserFactory.Client;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Account.FactoryAccount;
import com.example.Api.EmailApi.AuthenticationEmail;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class OpenAccountController implements Initializable {
    @FXML
    AnchorPane open_account_pane;
    @FXML
    ComboBox<String> title_cmb;
    @FXML
    public DatePicker DateOfBirth;
    @FXML
    public RadioButton male_radio_btn, female_radio_btn;
    @FXML
    ComboBox<String> occupation_cmb;
    @FXML
    ComboBox<String> acc_type_cmb;
    @FXML
    CheckBox single_checkbox, married_checkbox, divorced_checkbox, widowed_checkbox;
    @FXML
    TextField id_passport ,address ,name,email ,salary,phoneNum;

    PageLoader pageLoader = new PageLoader();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title_cmb.getItems().addAll("Mr.", "Mrs.", "Ms.");
        occupation_cmb.getItems().addAll("Accountant", "Actor/ Actress", "Architect", "Baker", "Businessman", "Carpenter",
                "Computer Programmer", "Chef", "Dentist", "Doctor", "Electrician", "Engineer", "Factory Worker", "Farmer",
                "Fireman", "Flight Attendant", "Judge", "Lawyer", "Musician", "Nurse", "Photographer", "Pilot", "Police Officer",
                "Self Employed", "Scientist", "Student", "Taxi Driver", "Teacher", "Worker");
        acc_type_cmb.getItems().addAll("Checking", "Saving", "Money Market", "Certificate Deposit");
    }
    void clearAllCheckBox(){
        single_checkbox.setSelected(false);
        married_checkbox.setSelected(false);
        divorced_checkbox.setSelected(false);
        widowed_checkbox.setSelected(false);
    }
    @FXML
    void singleChkHandler(){
        clearAllCheckBox();
        single_checkbox.setSelected(true);
    }
    @FXML
    void marriedChkHandler(){
        clearAllCheckBox();
        married_checkbox.setSelected(true);
    }
    @FXML
    void divorcedChkHandler(){
        clearAllCheckBox();
        divorced_checkbox.setSelected(true);
    }
    @FXML
    void widowedChkHandler(){
        clearAllCheckBox();
        widowed_checkbox.setSelected(true);
    }

    private String getSelectedStatus(){
        if(single_checkbox.isSelected())
            return single_checkbox.getText();
        else if(married_checkbox.isSelected())
            return married_checkbox.getText();
        else if(divorced_checkbox.isSelected())
            return divorced_checkbox.getText();
        else if(widowed_checkbox.isSelected())
            return widowed_checkbox.getText();
        return null;
    }
     @FXML
     String getGender(){
        if(male_radio_btn.isSelected())
            return male_radio_btn.getText();
        else if(female_radio_btn.isSelected())
            return female_radio_btn.getText();
        return null;
    }
    @FXML
    void closeWindow() {
        open_account_pane.setVisible(false);
    }

    @FXML
    void submit() throws SQLException {
        try{
            String Email=email.getText();
            String Address=address.getText();
            String []fullName= name.getText().split(" ");
            int ssn = Integer.parseInt(id_passport.getText());
            int Salary = Integer.parseInt(salary.getText());
            String status=getSelectedStatus();
            String accountType=acc_type_cmb.getValue();
            System.out.println(accountType);
            String []Id_Pass=new AuthenticationEmail().sendAuthenticationEmail(Email);
            int userID=Integer.parseInt(Id_Pass[0]);
            Account account= FactoryAccount.getAccount(accountType);
            account.setBalance(5000);
            account.setUser_id(userID);
            account.setAccountType(acc_type_cmb.getValue());
            account.setAccount_no((new IdGenerator().generate(Generator.generator.account_id)));
            Client c=new Client(fullName[0],fullName[1],userID,ssn,Id_Pass[1],Email,
                    account,Salary,Address,status,getGender());
            c.setAccount(account);
            Client.CreateUser(c);
            pageLoader.loadPage("/com/example/banksystem/AccountConfirmation.fxml","EDB",false, false);
            open_account_pane.setVisible(false);
        }
        catch (Exception e){
            System.out.println("Error in Open Account ");
            System.out.println(e.getMessage());
        }
    }
}
