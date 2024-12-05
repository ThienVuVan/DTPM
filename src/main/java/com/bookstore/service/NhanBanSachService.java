package com.bookstore.service;

import com.bookstore.entity.NhanBanSach;
import com.bookstore.entity.Sach;

import java.util.List;

public interface NhanBanSachService {
    public NhanBanSach saveNhanBan(NhanBanSach book);
    public List<NhanBanSach> getAll();
    public List<NhanBanSach> getByBookId(Integer id);
    public NhanBanSach getById(Integer id);
}
