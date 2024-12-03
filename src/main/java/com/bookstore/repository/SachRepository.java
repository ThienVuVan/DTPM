package com.bookstore.repository;

import com.bookstore.entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SachRepository extends JpaRepository<Sach, Integer> {
    Sach findSachByBookId(Integer id);
}
