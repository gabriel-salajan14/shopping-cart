package com.thoughtworks.codepairing.discount;

import com.thoughtworks.codepairing.model.Product;

public class TenPercentDiscount extends IDiscount{
    @Override
    public double calculateDiscount(Product product) {
        double discountAmount = product.getPrice() * 0.1;
        return super.applyDiscount(product, discountAmount);
    }

    @Override
    public int calculateLoyaltyPoints(Product product) {
        return (int) product.getPrice() / 10;
    }
}
