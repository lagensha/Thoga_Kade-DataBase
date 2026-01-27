package edu.icet.ecom.controller.order;

import edu.icet.ecom.model.dto.OrderDTO;
import javafx.collections.ObservableList;

public interface OrderInterFace {
    ObservableList<OrderDTO>viewOrder();
    void addOrder(String orderId,String date,String custId);
    void updateOrder(String date ,String custId,String orderId);
    void deleteOrder(String orderId);
}
