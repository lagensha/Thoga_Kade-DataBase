package edu.icet.ecom.controller.customer;


import edu.icet.ecom.model.dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerMain implements Initializable {
        CustomerController customerController = new CustomerController();
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<CustomerDTO> tblCustomerTable;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String title=txtTitle.getText();
        String name= txtName.getText();
        String dob= txtDOB.getText();
        double salary= Double.parseDouble(txtSalary.getText());
        String province=txtProvince.getText();
        String postalCode=txtPostalCode.getText();
        String address=txtAddress.getText();
        String city= txtCity.getText();

        customerController.addCustomer(id,title,name,dob,salary,province,postalCode,address,city);
        loadTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id=txtId.getText();
        customerController.deleteCustomer(id);
        loadTable();
        clearText();

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        tblCustomerTable.refresh();
        String id = txtId.getText();
        String title=txtTitle.getText();
        String name= txtName.getText();
        String dob= txtDOB.getText();
        Double salary= Double.parseDouble(txtSalary.getText());
        String province=txtProvince.getText();
        String postalCode=txtPostalCode.getText();
        String address=txtAddress.getText();
        String city= txtCity.getText();

        customerController.updateCustomer(title,name,dob,salary,address,city,province,postalCode,id);
        loadTable();
        clearText();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colDOB.setCellValueFactory(new PropertyValueFactory<>("date"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        loadTable();

        tblCustomerTable.getSelectionModel().selectedItemProperty().addListener((observableValue,oldValue, newValue) -> {
            if(newValue!=null){
                txtId.setText(newValue.getId());
                txtTitle.setText(newValue.getTitle());
                txtName.setText(newValue.getName());
                txtDOB.setText(String.valueOf(newValue.getDate()));
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());

            }
        });
    }
    public void loadTable(){
        tblCustomerTable.setItems(customerController.viewCustomer());

    }
    public void clearText(){
        txtPostalCode.clear();
        txtId.clear();
        txtName.clear();
        txtSalary.clear();
        txtProvince.clear();
        txtDOB.clear();
        txtCity.clear();
        txtAddress.clear();
        txtTitle.clear();
    }
}
