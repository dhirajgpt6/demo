package com.example.demo;

public interface OrderDao {
    Order save(Order order);

    Order findById(Long id);

    Order update(Order order);
}
