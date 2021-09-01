package com.night.sms.config;

import com.night.sms.AliSmsUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * @author night
 * @date 2021-08-16
 */
@Import(AliSmsUtil.class)
@ConfigurationProperties(value = "ali.sms")
public class AliSmsConfig {
	private String accessKeyId;
	private String accessKeySecret;

	private String product = "Dysmsapi";
	private String domain = "dysmsapi.aliyuncs.com";

	public String getProduct() {
		return product;
	}

	public String getDomain() {
		return domain;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
}
