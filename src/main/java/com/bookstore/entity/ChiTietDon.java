package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ChiTietDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailId;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Don order;

    private Integer quantity;
    private Double price;
}
