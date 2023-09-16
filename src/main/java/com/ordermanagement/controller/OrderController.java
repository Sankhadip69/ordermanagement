package com.ordermanagement.controller;

import com.ordermanagement.constants.UrlPaths;
import com.ordermanagement.dto.OrderDto;
import com.ordermanagement.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(UrlPaths.CREATE_ORDER_FOR_CUSTOMER)
    public ResponseEntity<OrderDto> createOrder(@PathVariable("customerId") Integer customerId, @Valid @RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(customerId, orderDto));
    }

}
