package edu.icet.ecom.controller.item;

import edu.icet.ecom.model.ItemDTO;
import javafx.collections.ObservableList;

public interface ItemInterFace {
    ObservableList<ItemDTO>viewItem();
    void addItem(String itemCode,String description,String packSize,double unitPrice,int qtyOnHand);
    void updateItem(String description,String packSize,double unitPrice,int qtyOnHand,String itemCod);
    void deleteUpdate(String itemCod);
}
