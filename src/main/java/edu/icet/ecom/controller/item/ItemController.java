package edu.icet.ecom.controller.item;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.model.dto.ItemDTO;
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
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO item VALUES(?,?,?,?,?)");
            preparedStatement.setObject(1,itemCode);
            preparedStatement.setObject(2,description);
            preparedStatement.setObject(3,packSize);
            preparedStatement.setObject(4,unitPrice);
            preparedStatement.setObject(5,qtyOnHand);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItem(String description, String packSize, double unitPrice, int qtyOnHand, String itemCode) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?");
            preparedStatement.setObject(1,description);
            preparedStatement.setObject(2,packSize);
            preparedStatement.setObject(3,unitPrice);
            preparedStatement.setObject(4,qtyOnHand);
            preparedStatement.setObject(5,itemCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteItem(String itemCode) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM item WHERE ItemCode=?");
            preparedStatement.setObject(1,itemCode);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
