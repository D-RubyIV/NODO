package org.example.bean;


import org.example.bean.primary.FooService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class BeanApplication{
    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(BeanApplication.class, args);

        FooService fooService = context.getBean(FooService.class);
        fooService.processTest();
    }
}
