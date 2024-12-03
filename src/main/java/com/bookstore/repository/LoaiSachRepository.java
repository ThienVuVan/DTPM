package com.bookstore.repository;

import com.bookstore.entity.LoaiSach;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LoaiSachRepository extends JpaRepository<LoaiSach, Integer> {
    LoaiSach findLoaiSachByCategoryId(Integer id);
}
