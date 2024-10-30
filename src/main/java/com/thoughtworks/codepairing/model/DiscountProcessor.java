package com.thoughtworks.codepairing.model;

import com.thoughtworks.codepairing.discount.*;

import java.util.HashMap;
import java.util.Map;

public class DiscountProcessor {

    private final Map<String, IDiscount> discountTypes = new HashMap<>();
    private final IDiscount noDiscount = new NoDiscount();

    public DiscountProcessor() {
        discountTypes.put("DIS_10", new TenPercentDiscount());
        discountTypes.put("DIS_15", new FifteenPercentDiscount());
        discountTypes.put("DIS_20", new TwentyPercentDiscount());
    }

    private IDiscount identifyDiscountType(Product product){
        if(product.getProductCode().startsWith("DIS_")) {
            return discountTypes.get(product.getProductCode().substring(0, 6));
        }
        else
            return noDiscount;
    }

    double processDiscount(Product product){
        IDiscount discount = identifyDiscountType(product);
        return discount.calculateDiscount(product);
    }

    int processLoyaltyPoint(Product product) {
        IDiscount discount = identifyDiscountType(product);
        return discount.calculateLoyaltyPoints(product);
    }

}
