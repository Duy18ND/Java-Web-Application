// Quy tắc đặt tên package là snake_case
package org.example.configs;

import org.example.Person;
import org.example.service.CustomerService;
import org.example.service.OrderService;
import org.example.service.impl.CustomerServiceImpl;
import org.example.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;

// Quy tắc đặt tên của Class --> PascalCase
public class AppConfiguration {

    @Bean
    // Bean có tên nhưng nếu không ghi sẽ lấy mặc định tên hàm
    public Person fullstack() {
        // Quy tắc đặt tên của biến camelCase
        Person hoangThaiMinh = new Person();
        hoangThaiMinh.setId(1);
        hoangThaiMinh.setName("Hoàng Thái Minh");
        hoangThaiMinh.setMajor("Full Stack");
        return hoangThaiMinh;
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl();
    }

}
