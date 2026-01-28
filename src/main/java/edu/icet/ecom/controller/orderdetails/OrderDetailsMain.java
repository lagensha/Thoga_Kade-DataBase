package edu.icet.ecom.controller.orderdetails;


import edu.icet.ecom.model.dto.OrderDetailsDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailsMain implements Initializable {

    OrderDetailsController orderDetailsController = new OrderDetailsController();
    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colOrderQTY;

    @FXML
    public TextField txtDiscount;

    @FXML
    private TableView<OrderDetailsDTO> tblOrderDetails;



    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtOrderQTY;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String orderId=txtOrderId.getText();
        String itemCode=txtItemCode.getText();
        int orderQTY= Integer.parseInt(txtOrderQTY.getText());
        int discount = Integer.parseInt(txtDiscount.getText());

        orderDetailsController.addOrderDetails(orderId,itemCode,orderQTY,discount);
        loadTable();
        clearText();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
            String orderId = txtOrderId.getText();
            orderDetailsController.deleteOrderDetails(orderId);
            loadTable();
            clearText();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
    clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        tblOrderDetails.refresh();
        String itemId=txtItemCode.getText();
        String QTY=txtOrderQTY.getText();
        String discount=txtDiscount.getText();
        String orderId=txtOrderId.getText();

        orderDetailsController.updateOrderDetails(itemId,Integer.parseInt(QTY),Integer.parseInt(discount),orderId);
        loadTable();
        clearText();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colOrderQTY.setCellValueFactory(new PropertyValueFactory<>("orderQTY"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        loadTable();
        tblOrderDetails.getSelectionModel().selectedItemProperty().addListener((observableValue,oldValue, newValue) -> {
            if(newValue!=null){
                txtOrderId.setText(newValue.getOrderId());
                txtItemCode.setText(newValue.getItemCode());
                txtOrderQTY.setText(String.valueOf(newValue.getOrderQTY()));
                txtDiscount.setText(String.valueOf(newValue.getDiscount()));
            }
        });

    }
    public void loadTable(){
        tblOrderDetails.setItems(orderDetailsController.viewOrderDetails());
    }
    public void clearText(){
        txtOrderId.clear();
        txtItemCode.clear();
        txtOrderQTY.clear();
        txtOrderQTY.clear();
    }
}
