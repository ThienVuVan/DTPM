package com.bookstore.service.impl;

import com.bookstore.entity.ChiTietDon;
import com.bookstore.repository.ChiTietDonRepository;
import com.bookstore.service.ChiTietDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChiTietDonServiceImpl implements ChiTietDonService {
    private final ChiTietDonRepository chiTietDonRepository;
    @Override
    public ChiTietDon save(ChiTietDon chiTietDon) {
        return chiTietDonRepository.save(chiTietDon);
    }
}
