package com.bookstore.repository;

import com.bookstore.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaChiRepository extends JpaRepository<DiaChi, Integer> {
    DiaChi findDiaChisByAddressId(Integer id);
}
