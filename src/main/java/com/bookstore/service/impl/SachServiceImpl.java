package com.bookstore.service.impl;

import com.bookstore.entity.Sach;
import com.bookstore.repository.SachRepository;
import com.bookstore.service.SachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SachServiceImpl implements SachService {
    private final SachRepository sachRepository;

    @Override
    public Sach saveSach(Sach book) {
        return sachRepository.save(book);
    }

    @Override
    public Sach updateSach(Sach book) {
        return sachRepository.save(book);
    }

    @Override
    public void deleteSach(Sach book) {
        sachRepository.delete(book);
    }

    @Override
    public Sach retrieveById(Integer id) {
        return sachRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sach> getAll() {
        return sachRepository.findAll();
    }
}
