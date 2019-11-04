package com.imooc.validator;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//模仿@Past,@NotBlank写
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =MyConstraintValidator.class)
public @interface MyValidate {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
