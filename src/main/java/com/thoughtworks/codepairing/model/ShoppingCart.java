package com.thoughtworks.codepairing.model;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Product> products;
    private Customer customer;
    private DiscountProcessor discountProcessor;

    public ShoppingCart(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
        this.discountProcessor = new DiscountProcessor();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Order checkout() {
        double totalPrice = 0;

        int loyaltyPointsEarned = 0;
        for (Product product : products) {
            totalPrice += discountProcessor.processDiscount(product);
            loyaltyPointsEarned += discountProcessor.processLoyaltyPoint(product);
        }

        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" + products.stream().map(p -> "- " + p.getName()+ ", "+p.getPrice()).collect(Collectors.joining("\n"));
    }
}
