package edu.icet.ecom.controller.item;

import edu.icet.ecom.model.dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemMain implements Initializable {
ItemController itemController = new ItemController();
    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQTY;

    @FXML
    private TableColumn<?, ?> colUnitPrize;

    @FXML
    private TableView<ItemDTO> tblItem;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtPackPrize;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String itemCode = txtItemCode.getText();
        String description = txtDescription.getText();
        String packSize= txtPackPrize.getText();
        double unitPrize=Double.parseDouble(txtUnitPrice.getText());
        int qty=Integer.parseInt(txtQtyOnHand.getText());

        itemController.addItem(itemCode,description,packSize,unitPrize,qty);
        loadTable();
        clearText();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtItemCode.getText();
        itemController.deleteItem(id);
        loadTable();
        clearText();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
            clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        tblItem.refresh();
        String description = txtDescription.getText();
        String packSize= txtPackPrize.getText();
        double unitPrize=Double.parseDouble(txtUnitPrice.getText());
        int qty=Integer.parseInt(txtQtyOnHand.getText());
        String itemCode = txtItemCode.getText();

        itemController.updateItem(description,packSize,unitPrize,qty,itemCode);
        loadTable();
        clearText();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colUnitPrize.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQTY.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        loadTable();
        tblItem.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                txtItemCode.setText(newValue.getItemCode());
                txtDescription.setText(newValue.getDescription());
                txtPackPrize.setText(newValue.getPackSize());
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
                txtQtyOnHand.setText(String.valueOf(newValue.getQtyOnHand()));

            }
        });
    }
    public void loadTable(){
        tblItem.setItems(itemController.viewItem());
    }
    public void clearText(){
        txtItemCode.clear();
        txtDescription.clear();
        txtPackPrize.clear();
        txtUnitPrice.clear();
        txtQtyOnHand.clear();
    }
}
