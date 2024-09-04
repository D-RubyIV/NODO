package org.example.intern.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ZeroOneValidator implements ConstraintValidator<ZeroOneConstraint, Integer> {

    @Override
    public void initialize(ZeroOneConstraint zeroOneConstraint) {
        ConstraintValidator.super.initialize(zeroOneConstraint);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        List<Integer> listAccepted = new ArrayList<>(List.of(0, 1));
        if (listAccepted.contains(value)){
            System.out.println("OK");
            return Boolean.TRUE;
        }
        else {
            System.out.println("NOT OK");
            return Boolean.FALSE;
        }
    }
}