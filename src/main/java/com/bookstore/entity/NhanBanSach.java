package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NhanBanSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookCopyId;

    private String isbn;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private Sach book;

    private String bookCondition;
}
