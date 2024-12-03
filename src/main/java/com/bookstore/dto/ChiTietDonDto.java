package com.bookstore.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiTietDonDto {
    Integer id;
    SachDto bookDto;
    Integer quantity;
}
