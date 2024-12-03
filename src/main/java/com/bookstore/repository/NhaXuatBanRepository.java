package com.bookstore.repository;

import com.bookstore.entity.NhaXuatBan;
import com.bookstore.entity.NhanBanSach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan, Integer> {
    NhaXuatBan findNhaXuatBanByPublisherId (Integer id);
}
