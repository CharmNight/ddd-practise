package com.night.model.user.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.night.validator.sms.PhoneValidator;
import com.night.validator.sms.SmsTypeValidator;
import org.springframework.validation.annotation.Validated;

/**
 * @author night
 * @date 2021-08-09
 */
@Validated
public class VerificationCodeRequest {
	/**
	 * 手机号
	 */
	@JsonProperty("mobile")
	@PhoneValidator
	private String mobile = null;
	/**
	 * 短信类型
	 */
	@JsonProperty("smsType")
	@SmsTypeValidator
	private String smsType = null;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
}
