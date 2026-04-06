package org.example.service.impl;

import org.example.service.CustomerService;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // ko có ngữ nghĩa nhưng nó là bean để khởi tạo
public class CustomerServiceImpl  implements CustomerService {
    // DI - Tiêm sự phụ thuộc
    @Autowired // sử dụng annotation @Autowired để DI bằng field
    private OrderService orderService; // field

    // Bao nhiêu cách tiêm DI - 3
//    1. Constructors
//    public CustomerServiceImpl(OrderService orderService) {
//        this.orderService = orderService;
//    }

//    2. Setter
//    public void setOrderService(OrderService orderService) {
//        this.orderService = orderService;
//    }


    // 3. Field


    @Override
    public void eat() {
        orderService.serve();
    }

    @Override
    public void sleep() {
        System.out.println("Đang ngủ để thư giãn ...");
    }
}
