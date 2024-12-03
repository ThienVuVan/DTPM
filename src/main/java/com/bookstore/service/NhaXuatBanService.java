package com.bookstore.service;

import com.bookstore.entity.NhaXuatBan;

import java.util.List;

public interface NhaXuatBanService {
    public NhaXuatBan getById(Integer id);
    List<NhaXuatBan> getAll();
}
