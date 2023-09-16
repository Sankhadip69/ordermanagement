package com.ordermanagement.entity;

import com.ordermanagement.enums.CustomerCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique =  true, nullable = false)
    private String email;

    private Boolean isActive;

    private LocalDateTime addedAt;

    @Enumerated(EnumType.STRING)
    private CustomerCategory customerCategory;

    @Column(unique =  true, nullable = false)
    private String mobileNumber;

    private String address;

    @Column(name = "order_count")
    private Integer orderCount;

    private Double totalCashbackEarned;

    @OneToMany(mappedBy = "customer" , targetEntity = Order.class , cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orderList;

}
