package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}