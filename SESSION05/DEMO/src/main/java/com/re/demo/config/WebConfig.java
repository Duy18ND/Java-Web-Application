package com.re.demo.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.re.demo")
public class WebConfig {
    //1. Bean StringResourceTemplateResolver -- Đọc cấu hình folder file view
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".html"); // Khi làm việc với resolver thì làm việc với .html
        //Set Character UTF-8 để nhận những ký tự tiếng việt
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    //2. Bean StringTemplateEngine -- Bộ máy trung tâm sử lý và chuyển các cú pháp Thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        //Để sử dụng được layoutDialect
//        engine.setDialect(new LayoutDialect());
        return engine;
    }

    //3. Bean ThymeleafViewResolver -- Giao tiếp Spring MVC với Thymeleaf
    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
