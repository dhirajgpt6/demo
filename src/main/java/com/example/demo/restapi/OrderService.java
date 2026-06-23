package com.example.demo.restapi;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
    public OrderTO GetOrderById(Long id){
        return new OrderTO();
    }
}
