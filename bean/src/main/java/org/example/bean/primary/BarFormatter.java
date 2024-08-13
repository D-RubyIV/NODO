package org.example.bean.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BarFormatter implements Formatter {

    @Override
    public String format() {
        return "bar";
    }
}