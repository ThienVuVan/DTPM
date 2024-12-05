package com.bookstore.service;

import com.bookstore.entity.Don;
import com.bookstore.entity.TaiKhoan;

import java.util.List;

public interface TaiKhoanService {
    public TaiKhoan retrieveById(Integer id);
    public TaiKhoan retrieveByEmail(String username);
    public TaiKhoan saveUser(TaiKhoan user);

    TaiKhoan login(String username, String password);
}
