package edu.icet.ecom.controller.orderdetails;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.model.dto.OrderDetailsDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsController implements OrderDetailsInterFace{
    @Override
    public ObservableList<OrderDetailsDTO> viewOrderDetails() {
        ObservableList<OrderDetailsDTO>orderDetailsDTOS= FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderDetail");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO(
                        resultSet.getString("OrderID"),
                        resultSet.getString("ItemCode"),
                        resultSet.getInt("OrderQTY"),
                        resultSet.getInt("Discount")
                );
                orderDetailsDTOS.add(orderDetailsDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailsDTOS;
    }

    @Override
    public void addOrderDetails(String orderId, String itemCode, int orderQTY, int discount) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orderDetail VALUES(?,?,?,?)");
            preparedStatement.setObject(1,orderId);
            preparedStatement.setObject(2,itemCode);
            preparedStatement.setObject(3,orderQTY);
            preparedStatement.setObject(4,discount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateOrderDetails(String itemCode, int orderQTY, int discount, String orderId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orderDetail SET ItemCode=?,OrderQTY=?,Discount=? WHERE OrderID=?");
            preparedStatement.setObject(1,itemCode);
            preparedStatement.setObject(2,orderQTY);
            preparedStatement.setObject(3,discount);
            preparedStatement.setObject(4,orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderDetails(String orderId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orderDetail WHERE OrderID = ?");
            preparedStatement.setObject(1,orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
