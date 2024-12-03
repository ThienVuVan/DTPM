package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ChiTietDon_NhanBanSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "orderDetailId", referencedColumnName = "orderDetailId")
    private ChiTietDon orderDetail;

    @ManyToOne
    @JoinColumn(name = "bookCopyId", referencedColumnName = "bookCopyId")
    private NhanBanSach bookCopyId;
}