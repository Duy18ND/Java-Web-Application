package org.example.btth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfig.class
                );

        AccountManagement accountManagement =
                context.getBean("accountManagement", AccountManagement.class);
        accountManagement.checkYourComputer("Đinh Quốc Khánh","NORMAL");

    }
}
