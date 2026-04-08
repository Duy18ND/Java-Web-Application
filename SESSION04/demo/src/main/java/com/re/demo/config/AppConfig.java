package com.re.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Đánh dấu là lớp cấu hình
@Configuration
//Bật chế độ WebMVC
@EnableWebMvc
//Quét các bean đang được khởi tạo
@ComponentScan(basePackages = "com.re.demo") //Quét thư mục
public class AppConfig {
    //Cấu hình bean ViewResolver để đọc được view
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //Cấu hình tiền tố
        viewResolver.setPrefix("/WEB-INF/view/");
        //Cấu hình hậu tố
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
