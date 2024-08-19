package org.example.bean.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FooFormatter implements Formatter {

    @Override
    public String format() {
        return "BEAN FOO";
    }
}
