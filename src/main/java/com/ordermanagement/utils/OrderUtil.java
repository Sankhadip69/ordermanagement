package com.ordermanagement.utils;

import com.ordermanagement.enums.CustomerCategory;
import org.springframework.stereotype.Component;

@Component
public class OrderUtil {

    public Integer getDiscountPercent(Integer noOforders) {
        if(noOforders >= 10 && noOforders < 20) {
            return 10;
        }else if(noOforders >= 20) {
            return 20;
        }
        return 0;
    }

    public CustomerCategory getCustomerCategory(Integer noOforders) {
        if(noOforders >= 10 && noOforders < 20) {
            return CustomerCategory.GOLD;
        }else if(noOforders >= 20) {
            return CustomerCategory.PLATINUM;
        }
        return CustomerCategory.REGULAR;
    }

}
