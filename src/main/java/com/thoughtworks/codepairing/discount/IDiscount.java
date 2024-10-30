package com.thoughtworks.codepairing.discount;

import com.thoughtworks.codepairing.model.Product;

public abstract class IDiscount {

    final double applyDiscount(Product product, double discountAmount){
        return product.getPrice() - discountAmount;
    }

    public double calculateDiscount(Product product) {
        return applyDiscount(product, 0);
    }

    public int calculateLoyaltyPoints(Product product) {
        return (int) product.getPrice() / 5;
    }
}
