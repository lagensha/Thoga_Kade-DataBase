package edu.icet.ecom.controller.item;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.model.ItemDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemController implements ItemInterFace{
    @Override
    public ObservableList<ItemDTO> viewItem() {
       ObservableList<ItemDTO>itemDTOS= FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ItemDTO itemDTO = new ItemDTO(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getInt("QtyOnHand")
                );
                itemDTOS.add(itemDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return itemDTOS;
    }

    @Override
    public void addItem(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) {

    }

    @Override
    public void updateItem(String description, String packSize, double unitPrice, int qtyOnHand, String itemCod) {

    }

    @Override
    public void deleteUpdate(String itemCod) {

    }
}
