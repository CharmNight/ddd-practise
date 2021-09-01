package com.night.user.sms.interfaces.dto;

import com.night.model.user.enums.SMSTypeEnum;
import lombok.Data;

/**
 * @author night
 * @date 2021-08-09
 */
@Data
public class VerificationCodeDTO {
	/**
	 * 手机号
	 */
	private String mobile = null;
	/**
	 * 短信类型
	 */
	private SMSTypeEnum smsType = null;
}
