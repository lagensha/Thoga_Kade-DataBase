package edu.icet.ecom.controller.order;

import edu.icet.ecom.model.dto.OrderDTO;
import javafx.collections.ObservableList;

public interface OrderInterFace {
    ObservableList<OrderDTO>viewOrder();
    void  addOrder(String orderId,String orderDate,String customerId);
    void  updateOrder(String orderDate,String customerId,String orderId);
    void deleteOrder(String orderId);
}
