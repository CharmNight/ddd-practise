package com.night.user.sms.infrastructure.sms;

import com.aliyuncs.exceptions.ClientException;
import com.night.model.user.enums.SMSTypeEnum;
import com.night.user.sms.AliSmsUtil;
import com.night.user.sms.domain.aggregate.SmsAggregate;
import com.night.user.sms.domain.service.SmsSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 阿里云 短信发送功能
 * @author night
 * @date 2021-08-09
 */
@Component
public class SmsSendServiceImpl implements SmsSendService {

	private final String ALI_TEMPLATE_CODE_LOGIN = "SMS_148325065";
	private final String ALI_TEMPLATE_CODE_UPDATE = "SMS_148325062";
	private final String ALI_TEMPLATE_CODE_SIGNUP = "SMS_148325063";

	@Autowired
	private AliSmsUtil aliSmsUtil;

	@Override
	public void aliSendSms(SmsAggregate smsAggregate) {
		String templateCode = doGetTemplateCodeByType(smsAggregate.getSmsType());

		try {
			aliSmsUtil.sendSms(templateCode, smsAggregate.getMobile(), smsAggregate.getSmsCode());
		} catch (ClientException e) {
			e.printStackTrace();
			throw new RuntimeException("短信发送失败");
		}
	}

	private String doGetTemplateCodeByType(SMSTypeEnum smsType) {
		if (smsType.equals(SMSTypeEnum.LOGIN)) {
			return ALI_TEMPLATE_CODE_LOGIN;
		}else if(smsType.equals(SMSTypeEnum.REGISTER)){
			return ALI_TEMPLATE_CODE_UPDATE;
		}else if(smsType.equals(SMSTypeEnum.BIND)){
			return ALI_TEMPLATE_CODE_SIGNUP;
		}else if(smsType.equals(SMSTypeEnum.BIND_WECHAT)){
			return ALI_TEMPLATE_CODE_SIGNUP;
		}else if(smsType.equals(SMSTypeEnum.UNBIND_WECHAT)){
			return ALI_TEMPLATE_CODE_SIGNUP;
		}
		return null;
	}
}
