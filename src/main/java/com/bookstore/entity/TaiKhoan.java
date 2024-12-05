package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private DiaChi address;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
}
