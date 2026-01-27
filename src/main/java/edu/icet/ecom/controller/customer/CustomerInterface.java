package edu.icet.ecom.controller.customer;

import edu.icet.ecom.model.dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface CustomerInterface {
    ObservableList<CustomerDTO> viewCustomer();
    void addCustomer(String id, String title, String name,String date,double salary,String address,String city,String province,String postalCode);
    void updateCustomer(String title, String name,String date,double salary,String address,String city,String province,String postalCode,String id);
    void deleteCustomer(String id);
}
