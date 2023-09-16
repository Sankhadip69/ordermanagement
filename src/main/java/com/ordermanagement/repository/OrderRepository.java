package com.ordermanagement.repository;

import com.ordermanagement.entity.Customer;
import com.ordermanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByCustomer(Customer customer);
}
