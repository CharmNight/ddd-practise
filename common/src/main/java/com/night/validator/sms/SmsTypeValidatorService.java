package com.night.validator.sms;

import com.night.model.user.enums.SMSTypeEnum;
import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author night
 * @date 2021-08-09
 */
public class SmsTypeValidatorService implements ConstraintValidator<SmsTypeValidator, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Strings.isEmpty(value)) {
			return false;
		}

		if (SMSTypeEnum.inEnum(value)){
			return true;
		}
		return false;
	}
}
