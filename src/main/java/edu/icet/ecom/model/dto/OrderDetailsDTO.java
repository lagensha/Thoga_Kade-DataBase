package edu.icet.ecom.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class OrderDetailsDTO {
    private String orderId;
    private String itemCode;
    private int orderQTY;
    private int discount;
}
