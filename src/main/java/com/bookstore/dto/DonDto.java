package com.bookstore.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonDto {
    Integer id;
    LocalDate date;
    Double totalPrice;
    String DeliveryAddress;
    String orderStatus;
    Boolean isConfirm;
    Boolean isEvaluate;
}
