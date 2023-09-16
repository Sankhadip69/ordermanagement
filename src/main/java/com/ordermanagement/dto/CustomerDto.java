package com.ordermanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ordermanagement.enums.CustomerCategory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    private Integer id;

    @NotNull
    @NotBlank
    private String name;

    @Email
    @NotNull
    @NotBlank
    private String email;

    private CustomerCategory customerCategory;

    @Pattern(regexp = "^[6789]\\d{9}$")
    private String mobileNumber;

    @NotNull
    @NotBlank
    private String address;

    private Double totalCashbackEarned;

    @JsonIgnoreProperties("customer")
    private List<OrderDto> orderList;
}
