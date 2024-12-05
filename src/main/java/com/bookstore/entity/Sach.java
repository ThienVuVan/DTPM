package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    private String title;
    private String author;
    private Double price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    private NhaXuatBan publisher;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private LoaiSach category;
}
