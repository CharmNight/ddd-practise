package com.night.user.sms.domain.aggregate;

import com.night.model.user.enums.SMSTypeEnum;
import com.night.user.sms.domain.vo.OutTimeVO;
import lombok.Getter;

import java.util.Random;

/**
 * @author night
 * @date 2021-08-09
 */
public class SmsAggregate {
	/**
	 * 默认短信
	 */
	private final String DEFAULT_CODE = "1234";
	/**
	 * 短信长度
	 */
	private final Integer CODE_LENGTH = 4;
	/**
	 * 默认安全的手机号开头数字
	 */
	private final String DEFAULT_PHONE_PRO = "119";

	/**
	 * 手机号
	 */
	@Getter
	private String mobile;
	/**
	 * 生成的验证码
	 */
	@Getter
	private String smsCode;
	/**
	 * 短信类型
	 */
	@Getter
	private SMSTypeEnum smsType;
	/**
	 * True 需要发送短息
	 * False 不需要发送短信
	 */
	private Boolean needSend;

	/**
	 * 发送超时时间
	 */
	@Getter
	private OutTimeVO outTimeVO;


	public SmsAggregate(String mobile, SMSTypeEnum smsType) {
		this.mobile = mobile;
		this.smsType = smsType;
		outTimeVO = new OutTimeVO();
	}

	public Boolean getNeedSend() {
		return needSend;
	}

	public void checkSmsNeedSend() {
		if (mobile.startsWith(DEFAULT_PHONE_PRO)) {
			this.needSend = false;
			return;
		}
		this.needSend = true;
	}

	/**
	 * 生成验证码
	 *
	 * @return
	 */
	public SmsAggregate genderSmsCode() {
		String code = "";
		if (this.needSend) {
			code = genderSmsCode(CODE_LENGTH);
		} else {
			code = DEFAULT_CODE;
		}
		this.smsCode = code;
		return this;
	}

	/**
	 * 生成验证码字符串
	 *
	 * @param codeLength
	 *
	 * @return
	 */
	private String genderSmsCode(Integer codeLength) {
		StringBuilder verificationCode = new StringBuilder();
		for (int i = 0; i < codeLength; i++) {
			verificationCode.append(new Random().nextInt(10));
		}
		return verificationCode.toString();
	}

	/**
	 * 修改是否能发送短信
	 *
	 * @param isOutTime
	 */
	public void modifyNeedSend(Boolean isOutTime) {
		this.needSend = isOutTime;
	}
}
