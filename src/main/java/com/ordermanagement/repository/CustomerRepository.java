package com.ordermanagement.repository;

import com.ordermanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByEmailOrMobileNumber(String email, String mobileNumber);

    @Query(nativeQuery = true, value = "select * from customer where order_count >= :orderCount")
    List<Customer> findByOrderGreaterthan(Integer orderCount);
}
