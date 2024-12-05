package com.bookstore.repository;

import com.bookstore.entity.ChiTietDon;
import com.bookstore.entity.Don;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiTietDonRepository extends JpaRepository<ChiTietDon, Integer> {
    List<ChiTietDon> findAllByOrder(Don don);
}
