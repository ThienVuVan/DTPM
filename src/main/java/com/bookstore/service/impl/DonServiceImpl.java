package com.bookstore.service.impl;

import com.bookstore.entity.ChiTietDon;
import com.bookstore.entity.Don;
import com.bookstore.repository.DonRepository;
import com.bookstore.service.DonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonServiceImpl implements DonService {
    private final DonRepository orderRepository;

    @Override
    public Don saveOrder(Don order) {
        return null;
    }

    @Override
    public Don updateOrder(Don order) {
        return null;
    }

    @Override
    public void deleteOrder(Don order) {

    }

    @Override
    public Don retrieveById(Integer id) {
        return null;
    }

    @Override
    public List<ChiTietDon> retrieveOrderItemsByOrderId(Integer orderId) {
        return null;
    }

    @Override
    public List<Don> getall() {
        return orderRepository.findAll();
    }
}
