package com.bookstore.service;

import com.bookstore.entity.ChiTietDon;
import com.bookstore.entity.Don;

import java.util.List;

public interface ChiTietDonService {
    public ChiTietDon save(ChiTietDon chiTietDon);
    public List<ChiTietDon> getByDon(Don don);
}
