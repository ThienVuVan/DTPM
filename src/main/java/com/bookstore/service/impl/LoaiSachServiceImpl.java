package com.bookstore.service.impl;

import com.bookstore.entity.LoaiSach;
import com.bookstore.repository.LoaiSachRepository;
import com.bookstore.service.LoaiSachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoaiSachServiceImpl implements LoaiSachService {
    private final LoaiSachRepository loaiSachRepository;

    @Override
    public LoaiSach getById(Integer id) {
        return loaiSachRepository.findLoaiSachByCategoryId(id);
    }

    @Override
    public List<LoaiSach> retrieveAllCategories() {
        return loaiSachRepository.findAll();
    }
}
