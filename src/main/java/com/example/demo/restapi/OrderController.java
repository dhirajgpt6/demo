package com.example.demo.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetOrderById(@PathVariable("id") Long id){
        OrderTO order = orderService.GetOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> CreateOrder(@RequestBody OrderTO orderTO){
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/search", name = "search order")
    public ResponseEntity<?> SearchOrders(@RequestParam("status") String status, @RequestParam("date") LocalDate date){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
