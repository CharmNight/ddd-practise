package com.night.user.sms.domain;

import com.night.model.user.enums.SMSTypeEnum;
import com.night.user.sms.domain.aggregate.SmsAggregate;
import com.night.user.sms.domain.service.SmsSendService;
import com.night.user.sms.infrastructure.repository.cache.SmsCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author night
 * @date 2021-08-09
 */
@Service
public class SmsDomain {

	@Autowired
	private SmsCache smsCache;

	@Autowired
	private SmsSendService smsSendService;

	/**
	 * 检查是否可以发送短信
	 *
	 * @param mobile
	 * @param smsType
	 * @return
	 */
	public SmsAggregate checkNeedSendSms(String mobile, SMSTypeEnum smsType) {
		SmsAggregate smsAggregate = new SmsAggregate(mobile, smsType);

		smsAggregate.checkSmsNeedSend();
		if (smsAggregate.getNeedSend()) {
			// 校验该手机号是否1分钟发送过短信
			Boolean isOutTime = smsCache.checkOutTime(smsAggregate);
			smsAggregate.modifyNeedSend(isOutTime);
		}

		return smsAggregate;
	}

	/**
	 * 发送短信
	 *
	 * @param smsAggregate
	 */
	public void sendSms(SmsAggregate smsAggregate) {
		// 生成 短信code
		smsAggregate.genderSmsCode();
		smsSendService.aliSendSms(smsAggregate);
	}
}
