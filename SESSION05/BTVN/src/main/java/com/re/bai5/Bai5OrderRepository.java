package com.re.bai5;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class Bai5OrderRepository {
    public List<OrderItem> getCurrentUserCart() {
        return Arrays.asList(
                new OrderItem("Phở bò xào lăn", 55000.0, 2),
                new OrderItem("Trà đá", 5000.0, 2),
                new OrderItem("Nem rán", 10000.0, 3)
        );
    }
}