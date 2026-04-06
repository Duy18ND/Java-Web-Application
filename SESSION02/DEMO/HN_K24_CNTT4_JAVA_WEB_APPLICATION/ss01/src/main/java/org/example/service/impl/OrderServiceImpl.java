package org.example.service.impl;

import org.example.service.OrderService;
import org.springframework.stereotype.Component;

@Component // muốn khởi tạo phải có bean
public class OrderServiceImpl implements OrderService {

    @Override
    public void serve() {
        System.out.println("Đang phục vụ khách hàng...");
    }

}
