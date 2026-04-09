package com.re.bai5;

public class OrderItem {
    private String name;
    private double price;
    private int quantity;
    private double itemTotal;

    public OrderItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.itemTotal = price * quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getItemTotal() { return itemTotal; }
}