package com.company.glovo.service.order.jpa;

import com.company.glovo.dto.order.Order;
import com.company.glovo.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    List<Order> listOfOrders = new ArrayList<>();

    @Override
    public List<Order> getOrderById(Integer id) {
        return listOfOrders.stream()
                .filter(listOfOrder -> listOfOrder.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrders() {
        return listOfOrders;
    }

    @Override
    public void save(Order order) {
        listOfOrders.add(order);
    }

    @Override
    public void update(Integer id, Order updatedOrderData) {
        for (Order result : listOfOrders) {
            if (id.equals(result.getId())) {
                listOfOrders.remove(result);
                listOfOrders.add(updatedOrderData);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        listOfOrders.removeIf(result -> id.equals(result.getId()));
    }
}
