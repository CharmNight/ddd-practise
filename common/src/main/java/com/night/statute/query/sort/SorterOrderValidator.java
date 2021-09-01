package com.night.statute.query.sort;


import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * 排序规则校验
 *
 * @author night
 *
 * @since 0.0.1
 * @version 0.0.1
 */
public class SorterOrderValidator implements ConstraintValidator<SorterOrder, String> {

	private HashSet<Object> sorterOrderSet = new HashSet<>();

	@Override
	public void initialize(SorterOrder constraintAnnotation) {
		sorterOrderSet.add("ascend");
		sorterOrderSet.add("descend");
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Strings.isBlank(value) || sorterOrderSet.contains(value);
	}
}
