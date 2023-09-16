package com.ordermanagement.controller;

import com.ordermanagement.constants.UrlPaths;
import com.ordermanagement.dto.CustomerDto;
import com.ordermanagement.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlPaths.APP_BASE_URL + UrlPaths.CUSTOMER_BASE)
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDto));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") Integer customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
}
