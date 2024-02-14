package com.company.glovo.service.order;

import com.company.glovo.dto.order.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderById(Integer id);

    List<Order> getOrders();

    void save(Order order);

    void update(Integer id, Order updatedOrderData);

    void delete(Integer id);
}
