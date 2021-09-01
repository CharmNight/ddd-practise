package com.night.user.sms.application.command;

import com.night.log.anntion.MyLogAnnotation;
import com.night.user.sms.domain.SmsDomain;
import com.night.user.sms.domain.aggregate.SmsAggregate;
import com.night.user.sms.infrastructure.repository.cache.SmsCache;
import com.night.user.sms.interfaces.dto.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author night
 * @date 2021-08-09
 */
@Service
public class SmsApplication {

	@Autowired
	private SmsDomain smsDomain;

	@Autowired
	private SmsCache smsCache;

	@MyLogAnnotation
	public void sendSms(VerificationCodeDTO verificationCodeDTO) {

		// 校验手机号分类 判断是否需要发送短信
		SmsAggregate smsAggregate = smsDomain.checkNeedSendSms(verificationCodeDTO.getMobile(), verificationCodeDTO.getSmsType());
		if (smsAggregate.getNeedSend()) {
			// 发送消息
			smsDomain.sendSms(smsAggregate);
		}
		// 存储Redis
		smsCache.saveSms(smsAggregate);
	}
}
