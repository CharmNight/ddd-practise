package com.night.user.sms.domain.service;

import com.night.user.sms.domain.aggregate.SmsAggregate;

/**
 * @author night
 * @date 2021-08-09
 */
public interface SmsSendService {
	/**
	 * 阿里云发送
	 * @param smsAggregate
	 */
	void aliSendSms(SmsAggregate smsAggregate);
}
