package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private DiaChi address;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role role;
}
