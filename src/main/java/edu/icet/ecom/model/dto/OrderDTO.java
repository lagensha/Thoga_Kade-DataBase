package edu.icet.ecom.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDTO {
    private String orderId;
    private String orderDate;
    private String custId;
}
