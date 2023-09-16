package com.ordermanagement.service;

import com.ordermanagement.dto.CustomerDto;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Integer id);
}
