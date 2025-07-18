package com.example.Order.Service.Project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders") // ✅ Renamed from "order"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private float price;

    private Long userId;
}
