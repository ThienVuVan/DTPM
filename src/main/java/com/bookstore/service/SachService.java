package com.bookstore.service;

import com.bookstore.entity.Sach;

import java.util.List;
import java.util.Optional;

public interface SachService {
    public Sach saveSach(Sach book);
    public Sach updateSach(Sach book);
    public void deleteSach(Sach book);
    Sach retrieveById(Integer id);
    public List<Sach> getAll();
}
