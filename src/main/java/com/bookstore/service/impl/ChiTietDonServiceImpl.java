package com.bookstore.service.impl;

import com.bookstore.entity.ChiTietDon;
import com.bookstore.entity.Don;
import com.bookstore.repository.ChiTietDonRepository;
import com.bookstore.service.ChiTietDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChiTietDonServiceImpl implements ChiTietDonService {
    private final ChiTietDonRepository chiTietDonRepository;
    @Override
    public ChiTietDon save(ChiTietDon chiTietDon) {
        return chiTietDonRepository.save(chiTietDon);
    }

    @Override
    public List<ChiTietDon> getByDon(Don don) {
        return chiTietDonRepository.findAllByOrder(don);
    }
}
