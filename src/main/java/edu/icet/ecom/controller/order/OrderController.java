package edu.icet.ecom.controller.order;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.model.dto.OrderDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController implements OrderInterFace{
    @Override
    public ObservableList<OrderDTO> viewOrder() {
        ObservableList<OrderDTO>orderDTOS= FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                OrderDTO orderDTO = new OrderDTO(
                resultSet.getString("OrderID"),
                resultSet.getString("OrderDate"),
                        resultSet.getString("CustID")
                        );
                    orderDTOS.add(orderDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return orderDTOS;
    }

    @Override
    public void addOrder(String orderId, String date, String custId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders VALUES(?,?,?)");
            preparedStatement.setObject(1,orderId);
            preparedStatement.setObject(2,date);
            preparedStatement.setObject(3,custId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateOrder(String date, String custId, String orderId) {
        
    }

    @Override
    public void deleteOrder(String orderId) {

    }
}
