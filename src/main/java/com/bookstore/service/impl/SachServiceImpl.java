package com.bookstore.service.impl;

import com.bookstore.entity.Sach;
import com.bookstore.repository.SachRepository;
import com.bookstore.service.SachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SachServiceImpl implements SachService {
    private final SachRepository sachRepository;

    @Override
    public Sach saveSach(Sach book) {
        return null;
    }

    @Override
    public Sach updateSach(Sach book) {
        return null;
    }

    @Override
    public void deleteSach(Sach book) {

    }

    @Override
    public Sach retrieveById(Integer id) {
        return null;
    }

    @Override
    public List<Sach> getAll() {
        return sachRepository.findAll();
    }
}
