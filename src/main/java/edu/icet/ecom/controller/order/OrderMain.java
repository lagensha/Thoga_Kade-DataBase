package edu.icet.ecom.controller.order;

import edu.icet.ecom.model.dto.OrderDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderMain implements Initializable {
        OrderController orderController = new OrderController();
    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableView<OrderDTO> tblOrder;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtOrderDate;

    @FXML
    private TextField txtOrderId;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String orderId=txtOrderId.getText();
        String orderDate=txtOrderDate.getText();
        String customerId=txtCustomerId.getText();

        orderController.addOrder(orderId,orderDate,customerId);
        loadTable();
        clearText();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        loadTable();
        tblOrder.getSelectionModel().selectedItemProperty().addListener((observableValue, oldVale, newVale) -> {
            if(newVale!=null){
                txtOrderId.setText(newVale.getOrderId());
                txtOrderDate.setText(newVale.getOrderDate());
                txtCustomerId.setText(newVale.getCustId());
            }
        });
    }
            public void loadTable(){
                tblOrder.setItems(orderController.viewOrder());
            }
    public void clearText(){
        txtOrderId.clear();
        txtOrderDate.clear();
        txtCustomerId.clear();
    }
}
