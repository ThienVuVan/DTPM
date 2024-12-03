package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    private TaiKhoan account;

    private LocalDateTime orderDate;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        Pending,
        Completed,
        Cancelled
    }
}
