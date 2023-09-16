package com.ordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String product;

    private Double amountPaid;

    private Double cashback;

    private Integer discountpercentage;

    @ManyToOne
    @JoinColumn(name = "fk_customer_id")
    private Customer customer;

    private Boolean success;

    private LocalDateTime orderTime;
}
