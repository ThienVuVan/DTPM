package com.bookstore.service.impl;

import com.bookstore.entity.NhaXuatBan;
import com.bookstore.repository.NhaXuatBanRepository;
import com.bookstore.service.NhaXuatBanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhaXuatBanServiceImpl implements NhaXuatBanService {
    private final NhaXuatBanRepository nhaXuatBanRepository;
    @Override
    public NhaXuatBan getById(Integer id) {
        return nhaXuatBanRepository.findNhaXuatBanByPublisherId(id);
    }

    @Override
    public List<NhaXuatBan> getAll() {
        return nhaXuatBanRepository.findAll();
    }
}
