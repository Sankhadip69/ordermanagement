package com.ordermanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {

    private Integer id;

    @NotNull
    @NotBlank
    private String product;

    @NotNull
    private Double amountPaid;

    private Double cashback;

    private Integer discountpercentage;

    @JsonIgnoreProperties("orderList")
    private CustomerDto customer;

    private Boolean success;

    private LocalDateTime orderTime;

}
