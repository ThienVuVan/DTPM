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
    @JoinColumn(name = "order_detail_id", referencedColumnName = "order_detail_id")
    private ChiTietDon orderDetail;

    @ManyToOne
    @JoinColumn(name = "book_copy_id", referencedColumnName = "book_copy_id")
    private NhanBanSach bookCopyId;
}