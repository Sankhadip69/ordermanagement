package com.ordermanagement.service;

import com.ordermanagement.dto.OrderDto;
import com.ordermanagement.entity.Customer;
import com.ordermanagement.entity.Order;
import com.ordermanagement.exception.ApiException;
import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.utils.OrderUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderUtil orderUtils;

    @Override
    public OrderDto createOrder(Integer customerId, OrderDto orderDto) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new ApiException("Customer with Id : " + customerId + " is not present" , HttpStatus.BAD_REQUEST));
        List<Order> customerPreviousOrders = orderRepo.findByCustomer(customer);
        Order order = new Order();
        order.setAmountPaid(orderDto.getAmountPaid());
        order.setProduct(orderDto.getProduct());
        order.setOrderTime(LocalDateTime.now());
        order.setSuccess(Boolean.TRUE);
        order.setDiscountpercentage(orderUtils.getDiscountPercent(customerPreviousOrders.size() + 1));
        customer.setCustomerCategory(orderUtils.getCustomerCategory(customerPreviousOrders.size() + 1));
        order.setCustomer(customer);
        Double cashback = (order.getDiscountpercentage() * order.getAmountPaid()) / 100;
        order.setCashback(cashback);
        customer.setOrderCount(customer.getOrderCount() + 1);
        customer.setTotalCashbackEarned(customer.getTotalCashbackEarned() + cashback);
        customerRepo.save(customer);
        Order savedOrder = orderRepo.save(order);
        return new ModelMapper().map(savedOrder, OrderDto.class);
    }

}
