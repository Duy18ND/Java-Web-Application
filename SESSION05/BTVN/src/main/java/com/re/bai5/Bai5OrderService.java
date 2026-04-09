package com.re.bai5;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bai5OrderService {

    private final Bai5OrderRepository repository;

    public Bai5OrderService(Bai5OrderRepository repository) {
        this.repository = repository;
    }

    public OrderSummary getQuickOrderSummary() {
        List<OrderItem> cartItems = repository.getCurrentUserCart();

        double subTotal = 0;
        for (OrderItem item : cartItems) {
            subTotal += item.getItemTotal();
        }

        double vatTax = subTotal * 0.10;
        double grandTotal = subTotal + vatTax;

        OrderSummary summary = new OrderSummary();
        summary.setItems(cartItems);
        summary.setSubTotal(subTotal);
        summary.setVatTax(vatTax);
        summary.setGrandTotal(grandTotal);

        return summary;
    }
}