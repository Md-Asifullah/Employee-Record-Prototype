/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package org.employeerecord;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author DELL
 */
public class MainController implements Initializable {
    
    private Label label;
    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldFname;
    @FXML
    private TextField textFieldLname;
    @FXML
    private TextField textFieldAge;
    @FXML
    private TextField textFieldNationality;
    @FXML
    private TextArea textAreaAddress;
    @FXML
    private Button buttonAdd;
    @FXML
    private TableView<Employees> display;
    @FXML
    private TableColumn<Employees, Integer> columnId;
    @FXML
    private TableColumn<Employees, String> columnFname;
    @FXML
    private TableColumn<Employees, String> columnLname;
    @FXML
    private TableColumn<Employees, Integer> columnAge;
    @FXML
    private TableColumn<Employees, String> columnDesignation;
    @FXML
    private TableColumn<Employees, String> columnNationality;
    @FXML
    private TableColumn<Employees, String> columnAddress;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private ComboBox<String> comboBoxDesignation;
    
    private String comboValue;
    ObservableList<String> list = FXCollections.observableArrayList("Programmer","Software Engineer", "Graphic Designer","Project Manager","Web Developer","System Analyst","Video Editor","3D Modeller");
    @FXML
    private Button buttonClear;
    @FXML
    private Label status;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxDesignation.setItems(list);
        showRecord();
    }    

    @FXML
    private void comboChanged(ActionEvent event) {
        comboValue = comboBoxDesignation.getValue();
    }
    
    public Connection getConnection(){
        Connection connection;
        try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeerecord","root","");
           return connection;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
        
    }
    
    public ObservableList<Employees> getRecord(){
        ObservableList<Employees> record = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM record";
        Statement statement;
        ResultSet resultset;
        try{
            statement = connection.createStatement();
            resultset = statement.executeQuery(query);
            Employees employees;
            while(resultset.next()){
                employees = new Employees(resultset.getInt("id"),resultset.getString("firstName"),resultset.getString("lastName"),resultset.getInt("age"),resultset.getString("designation"),resultset.getString("nationality"),resultset.getString("address"));
                record.add(employees);
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return record;
    }
    
    public void showRecord(){
        ObservableList<Employees> employeeList = getRecord();
        columnId.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("id"));
        columnFname.setCellValueFactory(new PropertyValueFactory<Employees, String>("firstName"));
        columnLname.setCellValueFactory(new PropertyValueFactory<Employees, String>("lastName"));
        columnAge.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("age"));
        columnDesignation.setCellValueFactory(new PropertyValueFactory<Employees, String>("designation"));
        columnNationality.setCellValueFactory(new PropertyValueFactory<Employees, String>("nationality"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<Employees, String>("address"));
        
        display.setItems(employeeList);
    }
    
    private void insertRecord(){
        String query = "INSERT INTO record VALUES (" + textFieldId.getText() + ",'" + textFieldFname.getText() + "','" + textFieldLname.getText() + "'," + textFieldAge.getText() + ",'" + comboBoxDesignation.getValue() + "','" + textFieldNationality.getText() + "','" + textAreaAddress.getText() + "')";
        executeQuery(query);
        showRecord();
    }
    
    private void updateRecord(){
        String query = "UPDATE record SET firstName = '" + textFieldFname.getText() + "', lastName = '" + textFieldLname.getText() + "', age = '" + textFieldAge.getText() + "', designation = '" + comboBoxDesignation.getValue() + "', nationality = '" + textFieldNationality.getText() + "', address = '" + textAreaAddress.getText() + "' WHERE id = " + textFieldId.getText();
         executeQuery(query);
         showRecord();
    }
    
    private void deleteRecord(){
         String query = "DELETE FROM record WHERE id = " + textFieldId.getText();
         executeQuery(query);
         showRecord();
    }

    private void executeQuery(String query) {
        Connection connection = getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    @FXML
    private void addRecord(ActionEvent event) {
        if(formValidate()){
            insertRecord();
            status.setText("New record has been added to database.");
            clearTextAction();
        }else{
            status.setText("Error! Please fill up all the fields to enter record.");
        }
        
    }

    @FXML
    private void updateRecordAction(ActionEvent event) {
        if(formValidate()){
            updateRecord();
            status.setText("Record has been updated.");
            clearTextAction();
        }else{
            status.setText("Error! Please select a record to update.");
        }
    }

    @FXML
    private void deleteRecordAction(ActionEvent event) {
        if(formValidate()){
            deleteRecord();
        status.setText("Record has been deleted.");
        clearTextAction();
        }else{
            status.setText("Error! Please select a record to delete.");
        }
    }

    @FXML
    private void mouseAction(MouseEvent event) {
        Employees employee = display.getSelectionModel().getSelectedItem();
        textFieldId.setText(String.valueOf(employee.getId()));
        textFieldFname.setText(employee.getFirstName());
        textFieldLname.setText(employee.getLastName());
        textFieldAge.setText(String.valueOf(employee.getAge()));
        comboBoxDesignation.setValue(employee.getDesignation());
        textFieldNationality.setText(employee.getNationality());
        textAreaAddress.setText(employee.getAddress());
        
    }

    @FXML
    private void clearText(ActionEvent event) {
        clearTextAction();
    }
    
    private boolean formValidate(){
        if((textFieldId.getText() == "") || (textFieldFname.getText() == "") || (textFieldLname.getText() == "") || (textFieldAge.getText() == "") || (comboBoxDesignation.getValue() == "") || (textFieldNationality.getText() == "") || (textAreaAddress.getText() == "")){
            return false;
        }else{
            return true;
        }  
    }
    
    private void clearTextAction(){
        textFieldId.setText("");
        textFieldFname.setText("");
        textFieldLname.setText("");
        textFieldAge.setText("");
        comboBoxDesignation.setValue("");
        textFieldNationality.setText("");
        textAreaAddress.setText("");
    }
    
}