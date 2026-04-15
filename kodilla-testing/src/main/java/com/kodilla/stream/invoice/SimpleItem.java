package com.kodilla.stream.invoice;

public class SimpleItem {
    private String productName;
    private double price;
    private int quantity;

    public SimpleItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getValue() {
        return price * quantity;
    }

    public String getProductName() {
        return productName;
    }
}
