package edu.icet.ecom.model.dto;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerDTO {
    String id;
    String title;
    String name;
    String date;
    double salary;
    String address;
    String city;
    String province;
    String postalCode;

}
