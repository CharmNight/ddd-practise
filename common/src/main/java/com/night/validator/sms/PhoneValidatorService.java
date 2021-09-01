package com.night.validator.sms;

import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author night
 * @date 2021-08-09
 */
public class PhoneValidatorService implements ConstraintValidator<PhoneValidator, String> {


	/**
	 * 手机号正则
	 */
	private final Pattern PATTERN = Pattern.compile("^1([0-9]{10})$");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Strings.isEmpty(value)) {
			return false;
		}
		Matcher matcher = PATTERN.matcher(value);

		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
}
