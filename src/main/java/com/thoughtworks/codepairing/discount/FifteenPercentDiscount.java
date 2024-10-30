package com.thoughtworks.codepairing.discount;

import com.thoughtworks.codepairing.model.Product;

public class FifteenPercentDiscount extends IDiscount {

    @Override
    public double calculateDiscount(Product product) {
        double discountAmount = product.getPrice() * 0.15;
        return super.applyDiscount(product, discountAmount);
    }

    @Override
    public int calculateLoyaltyPoints(Product product) {
        return (int) product.getPrice() / 15;
    }
}
