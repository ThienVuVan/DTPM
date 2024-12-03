package com.bookstore.service;

import com.bookstore.entity.ChiTietDon;
import com.bookstore.entity.Don;

import java.util.List;

public interface DonService {
    public Don saveOrder(Don order);
    public Don updateOrder(Don order);
    public void deleteOrder(Don order);
    public Don retrieveById(Integer id);
    List<ChiTietDon> retrieveOrderItemsByOrderId(Integer orderId);
}
