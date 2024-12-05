package com.bookstore.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhanBanSachDto {
    private Integer bookId;
    private String isbn;
    private String bookCondition;
}
