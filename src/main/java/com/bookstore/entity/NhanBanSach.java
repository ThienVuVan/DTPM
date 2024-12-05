package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NhanBanSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_copy_id")
    private Integer bookCopyId;

    private String isbn;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Sach sach;

    @ManyToOne
    @JoinColumn(name = "order_detail_id", referencedColumnName = "order_detail_id")
    private ChiTietDon orderDetail;

    @Column(name = "book_condition")
    private String bookCondition;
}
