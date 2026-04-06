package org.example;

import org.example.configs.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Bean - đọc cấu hình java class bean
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfiguration.class
                );

        // Lấy bean ra như nào?
        Person fullstack = (Person) context.getBean("fullstack");
        System.out.println(fullstack);
    }
}