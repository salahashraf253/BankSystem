package com.example.GUI;

import com.example.NotificationsObserver.DesktopNotificationBuilder;
import com.example.dataBase.DataBaseMapping;
import com.example.dataBase.Functions.DataBaseReader;
import com.example.banksystem.Account.Account;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import tray.notification.NotificationType;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class ViewAccountController implements Initializable {
    @FXML
    private TableView<Account> accounts_table;
    @FXML
    private TableColumn<Account, Integer> account_id_col;
    @FXML
    private TableColumn<Account, Integer> user_id_col;
    @FXML
    private TableColumn<Account, String> type_col;
    @FXML
    private TableColumn<Account, Integer> balance_col;
    @FXML
    private TableColumn<Account, Void> update_col;
    @FXML
    private TableColumn<Account, Void> delete_col;
    @FXML
    private TextField text_AccId;
    @FXML
    private TextField text_balance;
    @FXML
    private TextField text_type;
    @FXML
    private TextField text_userid;
    @FXML
    private AnchorPane center_pane, update_pane;
    @FXML
    ComboBox<String> title_cmb;
    @FXML
    public DatePicker DateOfBirth;
    @FXML
    public RadioButton male_radio_btn, female_radio_btn;
    @FXML
    private TextField occupation_txt;
    @FXML
    private CheckBox single_checkbox, married_checkbox, divorced_checkbox, widowed_checkbox;
    @FXML
    private TextField id_passport ,address , name, email ,salary,phoneNum;
    @FXML
    private TextField user_id_txt, acc_type_txt, acc_id_txt, balance_txt;

    ObservableList<Account> list;
    PreparedStatement ps=null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void InitCol(){
        account_id_col.setCellValueFactory(new PropertyValueFactory<>("account_no") );
        user_id_col.setCellValueFactory(new PropertyValueFactory<>("user_id") );
        balance_col.setCellValueFactory(new PropertyValueFactory<>("balance") );
        type_col.setCellValueFactory(new PropertyValueFactory<>("accountType") );
        addEditBtnToTable();
        addDeleteBtnToTable();
        try {
            list =DataBaseMapping.getAccounts();
            accounts_table.setItems(list);
        } catch (SQLException e) {

            System.out.println("Error in view account controller");
            System.out.println(e.getMessage());
        }
    }
    private void addEditBtnToTable(){
        Callback<TableColumn<Account, Void>, TableCell<Account, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Account, Void> call(final TableColumn<Account, Void> param) {
                final TableCell<Account, Void> cell = new TableCell<>() {
                    Image edit = new Image ("C:\\Users\\a7mds\\IdeaProjects\\BankSystem\\src\\main\\resources\\com\\example\\banksystem\\Images\\edit-24.png",24, 24, false, false);
                    private final JFXButton updateBtn = new JFXButton("  ", new ImageView(edit));
                    {
                        updateBtn.setOnAction((ActionEvent event) -> {
                            Account account = accounts_table.getSelectionModel().getSelectedItem();
                            int userId = 0;
                            try {
                                userId = account.getUser_id();
                            }
                            catch (Exception e){
                                DesktopNotificationBuilder.notifyUser("Please select the row First", NotificationType.ERROR);
                            }
                            DataBaseReader dbr = new DataBaseReader();
                            try {
                                String query ="select * from user where user_id='"+userId+"';";
                                ResultSet userData=dbr.read(query);
                                if(userData.next()){
                                    System.out.println("Account of user is found");
                                    long ssn=(userData.getLong("ssn"));
                                    String uEmail =(userData.getString("email"));
                                    String fName =(userData.getString("firstName"));
                                    String lName =(userData.getString("lastName"));
                                    String gender =(userData.getString("gender"));
                                    String status =(userData.getString("status"));
                                    Date dob = (userData.getDate("dob"));
                                    int income  =(userData.getInt("salary"));
                                    int mobile  =(userData.getInt("phone"));
                                    String uAddress =(userData.getString("address"));
                                    //----------------------------------------------------------
                                    name.setText(fName+" "+lName);
                                    if(gender.equalsIgnoreCase("Male"))
                                        male_radio_btn.setSelected(true);
                                    else
                                        female_radio_btn.setSelected(true);

                                    DateOfBirth.setUserData(dob);
                                    id_passport.setText(String.valueOf(ssn));
                                    salary.setText(String.valueOf(income));

                                    if(status.equalsIgnoreCase("Single"))
                                        single_checkbox.setSelected(true);
                                    else if(status.equalsIgnoreCase("Married"))
                                        married_checkbox.setSelected(true);
                                    else if(status.equalsIgnoreCase("Divorced"))
                                        divorced_checkbox.setSelected(true);
                                    else
                                        widowed_checkbox.setSelected(true);

                                    address.setText(uAddress);
                                    email.setText(uEmail);
                                    phoneNum.setText(String.valueOf(mobile));
                                    acc_type_txt.setText(account.getAccountType());
                                    acc_id_txt.setText(String.valueOf(account.getAccount_no()));
                                    balance_txt.setText(String.valueOf(account.getBalance()));
                                    user_id_txt.setText(String.valueOf(userId));
                                }
                                else System.out.println("no account found");
                            }
                            catch (SQLException e){
                                e.printStackTrace();
                            }
                            update_pane.setVisible(true);


                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(updateBtn);
                        }
                    }
                };
                return cell;
            }
        };
        update_col.setCellFactory(cellFactory);
    }
    private void addDeleteBtnToTable(){
        Callback<TableColumn<Account, Void>, TableCell<Account, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Account, Void> call(final TableColumn<Account, Void> param) {
                final TableCell<Account, Void> cell = new TableCell<>() {
                    Image delete = new Image ("C:\\Users\\a7mds\\IdeaProjects\\BankSystem\\src\\main\\resources\\com\\example\\banksystem\\Images\\delete-red-24.png",24, 24, false, false);
                    private final JFXButton deleteBtn = new JFXButton(" ", new ImageView(delete));
                    {
                        deleteBtn.setOnAction((ActionEvent event) -> {
                            Account account = accounts_table.getSelectionModel().getSelectedItem();
                            int userId = 0;
                            try {
                                userId = account.getUser_id();
                            }
                            catch (Exception e){
                                DesktopNotificationBuilder.notifyUser("Please select the row First", NotificationType.ERROR);
                            }
                            DataBaseReader db = new DataBaseReader();
                            DataBaseReader dbr = new DataBaseReader();
                            try {
                                String transQuery = "delete from transaction where user_id='"+userId+"'";
                                String accQuery ="delete from bank_account where user_id='"+userId+"'";
                                db.updateDatabase(transQuery);
                                dbr.updateDatabase(accQuery);
                                InitCol();
                            }
                            catch (SQLException e){
                                e.printStackTrace();
                            }
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(deleteBtn);
                        }
                    }
                };
                return cell;
            }
        };
        delete_col.setCellFactory(cellFactory);
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
    void closeUpdatePane() {
        update_pane.setVisible(false);
    }
    @FXML
    void submit() throws SQLException {
        try{
            int userId = Integer.parseInt(user_id_txt.getText());
            String Email = email.getText();
            String Address = address.getText();
            String []fullName= name.getText().split(" ");
            Long ssn = Long.parseLong(id_passport.getText());
            int Salary = Integer.parseInt(salary.getText());
            String gender = getGender();
            String status = getSelectedStatus();
            int phone = Integer.parseInt(phoneNum.getText());
            float balance = Float.parseFloat(balance_txt.getText());
            int accountNo = Integer.parseInt(acc_id_txt.getText());
            DataBaseReader dbr = new DataBaseReader();
            DataBaseReader db = new DataBaseReader();
                String userQuery ="UPDATE user SET firstName ='"+fullName[0]+"',lastName ='"
                        +fullName[1]+"',ssn ='"+ssn+"',salary ='"+Salary+"',address ='"
                        +Address+"',email ='"+Email+"',gender ='"+gender+"',phone ='"
                        +phone+"',status ='"+status+"' WHERE user_id='"+userId+"';";
                dbr.updateDatabase(userQuery);
            String query ="UPDATE bank_account SET balance ='"+balance+"' WHERE user_id='"+userId+"';";
            db.updateDatabase(query);
            DesktopNotificationBuilder.notifyUser("Account "+accountNo+" has been Updated",NotificationType.SUCCESS);
            update_pane.setVisible(false);

            InitCol();
        }
        catch (Exception e){
            System.out.println("Error in Update Account ");
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InitCol();
    }
}
