package org.example.intern.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ZeroOneValidator.class)

@Target({ ElementType.METHOD, ElementType.FIELD })

@Retention(RetentionPolicy.RUNTIME)

public @interface ZeroOneConstraint {
    String message() default "Chỉ chấp nhận 0 hoặc 1!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
