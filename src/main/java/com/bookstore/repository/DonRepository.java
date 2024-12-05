package com.bookstore.repository;

import com.bookstore.entity.ChiTietDon;
import com.bookstore.entity.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonRepository extends JpaRepository<Don, Integer> {
    @Query("SELECT o FROM Don o WHERE o.account.accountId = ?1")
    List<Don> findBy(Integer accountId);
    List<ChiTietDon> findChiTietDonByOrderId(Integer orderId);
}
