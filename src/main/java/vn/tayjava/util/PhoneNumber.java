package vn.tayjava.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( { ElementType.FIELD }) // áp dụng vào field của phone bên dto
@Retention(RetentionPolicy.RUNTIME) // Chạy trên môi trường RUNTIME
public @interface PhoneNumber {
    // Dưới này là những cái cố định có sẵn
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
