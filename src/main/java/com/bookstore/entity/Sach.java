package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String title;
    private String author;
    private Double price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "publisherId", referencedColumnName = "publisherId")
    private NhaXuatBan publisher;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private LoaiSach category;
}
