package com.bookstore.repository;

import com.bookstore.entity.ChiTietDon;
import com.bookstore.entity.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonRepository extends JpaRepository<Don, Integer> {
//    Don findDonById(Integer id);

//    @Query("select oi from ChiTietDon oi where oi.order.id = :orderId")
//    List<ChiTietDon> findChiTietDonByDonId(Integer orderId);
}
