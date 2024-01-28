package com.webproject.foodservice.dto;

import com.webproject.foodservice.entity.Customer;
import com.webproject.foodservice.entity.Order;
import com.webproject.foodservice.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Order order;
    private Set<OrderItem> orderItems;
}
