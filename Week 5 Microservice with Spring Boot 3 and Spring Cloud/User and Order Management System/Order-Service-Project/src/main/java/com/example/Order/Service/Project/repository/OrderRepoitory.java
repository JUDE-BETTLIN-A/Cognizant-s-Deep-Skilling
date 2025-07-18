package com.example.Order.Service.Project.repository;

import com.example.Order.Service.Project.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepoitory extends JpaRepository<Order, Long> {
}
