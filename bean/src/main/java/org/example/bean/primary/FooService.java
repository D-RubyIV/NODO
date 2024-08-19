package org.example.bean.primary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FooService {
    @Autowired
    @Qualifier(value = "BarFormatter")
    private Formatter formatter;

    public void processTest(){
        System.out.println(formatter.format());
    }
}