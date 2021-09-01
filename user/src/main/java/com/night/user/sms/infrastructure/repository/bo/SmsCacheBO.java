package com.night.user.sms.infrastructure.repository.bo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author night
 * @date 2021-08-09
 */
@Data
public class SmsCacheBO {
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 验证码
	 */
	private String verificationCode;

	/**
	 * 验证码类型
	 */
	private Integer codeType;

	/**
	 * 状态
	 */
	private Boolean status;

	/**
	 * 创建时间
	 */
	private Long createdAt;

	public SmsCacheBO(String mobile, String verificationCode, Integer codeType) {
		this.mobile = mobile;
		this.verificationCode = verificationCode;
		this.codeType = codeType;
		this.status = Boolean.FALSE;
		this.createdAt = System.currentTimeMillis();
	}

	public Map toMap(){
		HashMap<String, Object> smsMap = new HashMap<>();
		smsMap.put("verificationCode", verificationCode);
		smsMap.put("code_type", codeType);
		smsMap.put("status", status);
		smsMap.put("created_at", createdAt);
		return smsMap;
	}
}
