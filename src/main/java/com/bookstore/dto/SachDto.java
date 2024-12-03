package com.bookstore.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SachDto {
    private Integer bookId;
    private String title;
    private String author;
    private Double price;
    private Integer stock;
    private Integer publisher_id;
    private Integer category_id;
}
