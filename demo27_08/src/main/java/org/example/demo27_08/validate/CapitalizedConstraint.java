package org.example.demo27_08.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CapitalizedValidator.class)
// `@Constraint` đánh dấu rằng đây là một custom validation constraint (ràng buộc kiểm tra hợp lệ).
// `validatedBy = CapitalizedValidator.class` chỉ định lớp `CapitalizedValidator` sẽ chứa logic kiểm tra hợp lệ cho annotation này.

@Target({ ElementType.METHOD, ElementType.FIELD })
// `@Target` chỉ định các vị trí có thể áp dụng annotation này.
// Ở đây, annotation `CapitalizedConstraint` có thể được sử dụng trên các phương thức (`METHOD`) và các trường dữ liệu (`FIELD`).

@Retention(RetentionPolicy.RUNTIME)
// `@Retention` chỉ định thời gian tồn tại của annotation này.
// `RUNTIME` có nghĩa là annotation sẽ tồn tại trong quá trình chạy chương trình, và có thể được truy cập thông qua phản chiếu (reflection).

public @interface CapitalizedConstraint {
    String message() default "Chữ cái đầu phải viết hoa!";
// `message()` định nghĩa thông báo lỗi mặc định

    Class<?>[] groups() default {};
// `groups()` được sử dụng để nhóm các ràng buộc lại với nhau. Nó thường được sử dụng khi bạn muốn nhóm các ràng buộc theo một số tiêu chí nhất định.
// Mặc định nó là một mảng rỗng.

    Class<? extends Payload>[] payload() default {};
// `payload()` cho phép cung cấp thêm thông tin về lỗi, chẳng hạn như mức độ nghiêm trọng của lỗi.
// Mặc định nó cũng là một mảng rỗng.
}
