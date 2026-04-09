package com.re.bai5;

import java.util.List;

public class OrderSummary {
    private List<OrderItem> items;
    private double subTotal;
    private double vatTax;
    private double grandTotal;

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    public double getSubTotal() { return subTotal; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }
    public double getVatTax() { return vatTax; }
    public void setVatTax(double vatTax) { this.vatTax = vatTax; }
    public double getGrandTotal() { return grandTotal; }
    public void setGrandTotal(double grandTotal) { this.grandTotal = grandTotal; }
}