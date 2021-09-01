package com.night.model.user.enums;

import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
public enum SMSTypeEnum {
	/**
	 * 登陆
	 */
	LOGIN("login", 0),
	/**
	 * 密码登陆
	 */
	REVISE_PWD("revisePwd", 1),
	/**
	 * 注册
	 */
	REGISTER("register", 2),
	/**
	 * 绑定微信
	 */
	BIND_WECHAT("bindWechat", 4),
	/**
	 * 解绑微信
	 */
	UNBIND_WECHAT("unbindWechat", 5),
	/**
	 * 绑定
	 */
	BIND("bind", 3);

	private String smsTypeName;
	private int smsTypeCode;

	SMSTypeEnum(String smsTypeName, int smsTypeCode) {
		this.smsTypeName = smsTypeName;
		this.smsTypeCode = smsTypeCode;
	}

	public static SMSTypeEnum valuesOf(String smsTypeName){
		if (inEnum(smsTypeName)) {
			if (smsTypeName.equals(LOGIN.smsTypeName)) {
				return LOGIN;
			}
			else if (smsTypeName.equals(REVISE_PWD.smsTypeName)) {
				return REVISE_PWD;
			}
			else if (smsTypeName.equals(REGISTER.smsTypeName)) {
				return REGISTER;
			}
			else if (smsTypeName.equals(BIND_WECHAT.smsTypeName)) {
				return BIND_WECHAT;
			}
			else if (smsTypeName.equals(UNBIND_WECHAT.smsTypeName)) {
				return UNBIND_WECHAT;
			}
			else if (smsTypeName.equals(BIND.smsTypeName)) {
				return BIND;
			}
		}
		throw new RuntimeException("类型错误");
	}

	public static Boolean inEnum(String smsTypeName){
		System.out.println(smsTypeName);
		if (Strings.isEmpty(smsTypeName)) {
			return false;
		}
		if (smsTypeName.equals(LOGIN.smsTypeName)) {
			return true;
		}
		else if (smsTypeName.equals(REVISE_PWD.smsTypeName)) {
			return true;
		}
		else if (smsTypeName.equals(REGISTER.smsTypeName)) {
			return true;
		}
		else if (smsTypeName.equals(BIND_WECHAT.smsTypeName)) {
			return true;
		}
		else if (smsTypeName.equals(UNBIND_WECHAT.smsTypeName)) {
			return true;
		}
		else if (smsTypeName.equals(BIND.smsTypeName)) {
			return true;
		}
		return false;
	}
}