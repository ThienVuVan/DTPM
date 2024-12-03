package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NhaXuatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;

    private String publisherName;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private DiaChi address;
}