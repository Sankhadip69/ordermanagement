package com.ordermanagement.service;

import com.ordermanagement.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(Integer customerId, OrderDto orderDto);
}
