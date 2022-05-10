package com.example.GUI;

import com.example.Generator.AccountIDGenerator;
import com.example.UserFactory.Client;
import com.example.banksystem.Account.Account;
import com.example.banksystem.Account.FactoryAccount;
import com.example.notification.AuthenticationEmail;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javax.crypto.Cipher;
import java.net.URL;
import java.util.ResourceBundle;


public class OpenAccountController implements Initializable {

    @FXML
    public DatePicker DateOfBirth;
    public RadioButton male_Radio_Btn;
    public RadioButton female_Radio_Btn;
    @FXML
    AnchorPane open_account_pane;
    @FXML
    ComboBox<String> title_cmb;
    @FXML
    ComboBox<String> occupation_cmb;
    @FXML
    ComboBox<String> acc_type_cmb;
    @FXML
    CheckBox single_checkbox, married_checkbox, divorced_checkbox, widowed_checkbox;
    @FXML
    TextField Id_passport ,address ,name,email ,salary,phoneNum;

    PageLoader pageLoader = new PageLoader();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title_cmb.getItems().addAll("Mr.", "Mrs.", "Ms.");
        occupation_cmb.getItems().addAll("Accountant", "Actor/ Actress", "Architect", "Baker", "Businessman", "Carpenter",
                "Computer Programmer", "Chef", "Dentist", "Doctor", "Electrician", "Engineer", "Factory Worker", "Farmer",
                "Fireman", "Flight Attendant", "Judge", "Lawyer", "Musician", "Nurse", "Photographer", "Pilot", "Police Officer",
                "Self Employed", "Scientist", "Student", "Taxi Driver", "Teacher", "Worker");
        acc_type_cmb.getItems().addAll("Checking", "Saving", " Money Market", "Certificate Deposit");
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
    private String getGender(){
        if(male_Radio_Btn.isSelected()){
            return "male";
        }
        else return "female";
    }
    @FXML
    void closeWindow() {
        open_account_pane.setVisible(false);
    }

    @FXML
    void submit(){
        try{
            String Email=email.getText();
            String Address=address.getText();
            String []fullName= name.getText().split(" ");
            int ssn = Integer.parseInt(Id_passport.getText());
            int Salary = Integer.parseInt(salary.getText());
            String status=getSelectedStatus();
            String accountType=acc_type_cmb.getValue();
            System.out.println(accountType);
            String []Id_Pass=new AuthenticationEmail().sendAuthenticationEmail(Email);
            int userID=Integer.parseInt(Id_Pass[0]);
            pageLoader.loadPage("/com/example/banksystem/AccountConfirmation.fxml","EDB",false, false);
            Account account= FactoryAccount.getAccount(accountType);
            account.setBalance(0);
            account.setUser_id(userID);
            account.setAccountType(acc_type_cmb.getValue());
            account.setAccount_no(Integer.parseInt(new AccountIDGenerator().build()));
            Client c=new Client(fullName[0],fullName[1],userID,ssn,Id_Pass[1],Email,
                    account,Salary,Address,status,getGender());
            c.setAccount(account);
            Client.CreateUser(c);
            open_account_pane.setVisible(false);

        }
        catch (Exception e){
            System.out.println("Error in Open Account ");
            System.out.println(e.getMessage());
        }
    }
}
