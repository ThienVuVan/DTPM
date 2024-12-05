package com.bookstore.service.impl;

import com.bookstore.entity.NhanBanSach;
import com.bookstore.repository.NhanBanSachRepository;
import com.bookstore.service.NhanBanSachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhanBanSachServiceImpl implements NhanBanSachService {
    private final NhanBanSachRepository nhanBanSachRepository;
    @Override
    public NhanBanSach saveNhanBan(NhanBanSach book) {
        return nhanBanSachRepository.save(book);
    }

    @Override
    public List<NhanBanSach> getAll() {
        return nhanBanSachRepository.findAll();
    }

    @Override
    public List<NhanBanSach> getByBookId(Integer id) {
        return nhanBanSachRepository.findNhanBanSachByBookId(id);
    }

    @Override
    public NhanBanSach getById(Integer id) {
        return nhanBanSachRepository.findById(id).orElse(null);
    }
}
