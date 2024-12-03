package com.bookstore.repository;

import com.bookstore.entity.NhaXuatBan;
import com.bookstore.entity.NhanBanSach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanBanSachRepository extends JpaRepository<NhanBanSach, Integer> {
    NhanBanSach findNhanBanSachByBookCopyId(Integer id);
}
