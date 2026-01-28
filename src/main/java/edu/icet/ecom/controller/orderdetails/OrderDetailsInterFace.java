package edu.icet.ecom.controller.orderdetails;

import edu.icet.ecom.model.dto.OrderDetailsDTO;
import javafx.collections.ObservableList;

public interface OrderDetailsInterFace {
    ObservableList<OrderDetailsDTO>viewOrderDetails();
    void addOrderDetails(String orderId,String itemCode,int orderQTY, int discount);
    void updateOrderDetails(String itemCode,int orderQTY, int discount,String orderId);
    void deleteOrderDetails(String orderId);
}
