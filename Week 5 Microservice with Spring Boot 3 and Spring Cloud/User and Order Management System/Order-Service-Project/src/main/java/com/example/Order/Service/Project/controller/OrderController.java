package com.example.Order.Service.Project.controller;

import com.example.Order.Service.Project.entity.Order;
import com.example.Order.Service.Project.FeignClient.UserClient;
import com.example.Order.Service.Project.repository.OrderRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepoitory orderRepository;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // Validate user exists
        Map<String, Object> user = userClient.getUserById(order.getUserId());
        if (user == null || user.get("id") == null) {
            throw new RuntimeException("User not found");
        }

        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
