package com.bookstore.service.impl;

import com.bookstore.entity.TaiKhoan;
import com.bookstore.repository.TaiKhoanRepository;
import com.bookstore.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private final TaiKhoanRepository taiKhoanRepository;

    @Override
    public TaiKhoan retrieveById(Integer id) {
        return taiKhoanRepository.findTaiKhoanByAccountId(id);
    }

    @Override
    public TaiKhoan retrieveByEmail(String email) {
        return taiKhoanRepository.findTaiKhoanByEmail(email);
    }

    @Override
    public TaiKhoan saveUser(TaiKhoan user) {
        return taiKhoanRepository.save(user);
    }
}
