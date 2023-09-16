package com.ordermanagement.service;

import com.ordermanagement.dto.CustomerDto;
import com.ordermanagement.entity.Customer;
import com.ordermanagement.enums.CustomerCategory;
import com.ordermanagement.exception.ApiException;
import com.ordermanagement.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepo;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        boolean present = customerRepo.findByEmailOrMobileNumber(customerDto.getEmail(), customerDto.getMobileNumber()).isPresent();
        if(present) {
            throw new ApiException("Customer with same email or mobile Number already exists !!", HttpStatus.BAD_REQUEST);
        }
        Customer customer = dtoToEntity(customerDto);
        customer.setTotalCashbackEarned(0.0);
        customer.setOrderCount(0);
        customer.setIsActive(Boolean.TRUE);
        customer.setAddedAt(LocalDateTime.now());
        customer.setCustomerCategory(CustomerCategory.REGULAR);
        return entityToDto(customerRepo.save(customer));
    }



    private Customer dtoToEntity(CustomerDto dto) {
        ModelMapper mm = new ModelMapper();
        return mm.map(dto, Customer.class);
    }

    private CustomerDto entityToDto(Customer entity) {
        ModelMapper mm = new ModelMapper();
        return mm.map(entity, CustomerDto.class);
    }



    @Override
    public CustomerDto getCustomerById(Integer id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new ApiException("Customer with id : " + id + " doesnot exists !!", HttpStatus.BAD_REQUEST));
        return entityToDto(customer);
    }
}
