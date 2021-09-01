package com.night.validator.sms;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * @author night
 * @date 2021-08-09
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = SmsTypeValidatorService.class)
public @interface SmsTypeValidator {
	String message() default "短信类型错误";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
