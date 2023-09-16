package com.ordermanagement.config;

import com.ordermanagement.entity.Customer;
import com.ordermanagement.enums.CustomerCategory;
import com.ordermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.List;
import java.util.stream.Collectors;

public class CronScheduler {

    @Autowired
    private CustomerRepository customerRepo;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendNotification() {
        List<Customer> customerList = customerRepo.findByOrderGreaterthan(7);
        List<Customer> goldNotifcation = customerList.stream().filter((customer) -> customer.getOrderCount() < 10).collect(Collectors.toList());
        List<Customer> platinumNotifcation = customerList.stream().filter((customer) -> customer.getOrderCount() >= 17 && customer.getOrderCount() < 20).collect(Collectors.toList());
        goldNotifcation.forEach((customer) -> sendEmail(CustomerCategory.GOLD, customer.getEmail()));
        platinumNotifcation.forEach((customer) -> sendEmail(CustomerCategory.PLATINUM, customer.getEmail()));
        ;
    }

    public void sendEmail(CustomerCategory category, String email) {
        System.out.println("Sending email to : " + email + " -> You are approaching close to unlock " + category.toString() + " membership !! Place a order now...");
    }
}
