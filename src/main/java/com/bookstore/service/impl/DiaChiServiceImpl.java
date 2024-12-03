package com.bookstore.service.impl;

import com.bookstore.entity.DiaChi;
import com.bookstore.repository.DiaChiRepository;
import com.bookstore.service.DiaChiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaChiServiceImpl implements DiaChiService {
    private final DiaChiRepository diaChiRepository;
    @Override
    public DiaChi retrieveById(Integer id) {
        return diaChiRepository.findDiaChisByAddressId(id);
    }
}
