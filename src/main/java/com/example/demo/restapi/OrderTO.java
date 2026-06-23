package com.example.demo.restapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderTO {
    private Long orderId;
    private Long customerId;
    private String customerName;
    private String customerAddress;
}
