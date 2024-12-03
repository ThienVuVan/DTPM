package com.bookstore.dto;

import com.bookstore.entity.DiaChi;
import com.bookstore.entity.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanDto {
    private Integer accountId;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private Integer address_id;
    private Integer role_id;
}


