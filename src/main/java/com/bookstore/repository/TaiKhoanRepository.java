package com.bookstore.repository;


import com.bookstore.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    TaiKhoan findTaiKhoanByAccountId(Integer id);
    TaiKhoan findTaiKhoanByEmail(String email);
}
