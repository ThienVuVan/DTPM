package com.bookstore.service;

import com.bookstore.entity.LoaiSach;

import java.util.List;

public interface LoaiSachService {
    public LoaiSach getById(Integer id);
    public List<LoaiSach> retrieveAllCategories();
}
