package com.re.bai1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;


public class AppConfig {
    @Bean
    public SpringResourceTemplateResolver templateResolver() {

        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

        resolver.setPrefix("/WEB-INF/views"); //Sai thư mục chuẩn -> teplates
        resolver.setSuffix("/WEB-INF/templates");

//        resolver.setSuffix(".jsp");// Sai khi dùng hậu tố .jsp -> .html
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");

        return resolver;

    }
}
