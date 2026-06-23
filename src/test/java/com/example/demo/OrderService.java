package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class OrderService {

    private final OrderDao orderDao;

    // constructor injection (BEST PRACTICE)
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Order addOrder(Order order) {
        if (Objects.isNull(order)) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        return orderDao.save(order);
    }

    public Order getOrder(Long id) {
        return orderDao.findById(id);
    }

    public Order updateOrder(Order order) {
        return orderDao.update(order);
    }
}

