package com.night.statute.query.sort;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 排序时的顺序必须只能 为ascend 和 descend
 *
 * @author night
 *
 * @since 0.0.1
 * @version 0.0.1
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SorterOrderValidator.class)
@Documented
public @interface SorterOrder {
	String message() default "排序值仅能为ascend 和 descend";
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
