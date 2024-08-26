package org.example.demo22_08.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class CapitalizedValidator implements ConstraintValidator<CapitalizedConstraint, String> {
// Lớp `CapitalizedValidator` triển khai giao diện `ConstraintValidator`.
// `ConstraintValidator<CapitalizedConstraint, String>` nghĩa là lớp này kiểm tra ràng buộc `CapitalizedConstraint` trên các giá trị kiểu `String`.

    @Override
    public void initialize(CapitalizedConstraint constraintAnnotation) {
        // Phương thức `initialize` được gọi khi khởi tạo validator.
        // Ở đây, nó chỉ gọi phương thức `initialize` của lớp cha (`ConstraintValidator`), không thực hiện thêm hành động nào.
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!StringUtils.hasLength(value)) return Boolean.FALSE;
        if(!Character.isUpperCase(value.charAt(0))) return Boolean.FALSE;

        return Boolean.TRUE;    }
}