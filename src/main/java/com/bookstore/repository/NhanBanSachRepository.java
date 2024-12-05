package com.bookstore.repository;

import com.bookstore.entity.NhaXuatBan;
import com.bookstore.entity.NhanBanSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanBanSachRepository extends JpaRepository<NhanBanSach, Integer> {
    @Query("SELECT n FROM NhanBanSach n WHERE n.sach.bookId = ?1")
    List<NhanBanSach> findNhanBanSachByBookId(Integer id);
    // Tìm bản sao sách bất kỳ có orderDetailId null
    @Query("SELECT n FROM NhanBanSach n WHERE n.orderDetail IS NULL")
    NhanBanSach findFirstByOrderDetailIsNull();
}
