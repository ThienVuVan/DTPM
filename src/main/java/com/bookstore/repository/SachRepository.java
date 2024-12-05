package com.bookstore.repository;

import com.bookstore.entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SachRepository extends JpaRepository<Sach, Integer> {
}
