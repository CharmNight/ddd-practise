package com.night.user.sms.infrastructure.repository.convector;

import com.night.user.sms.domain.aggregate.SmsAggregate;
import com.night.user.sms.infrastructure.repository.bo.SmsCacheBO;

/**
 * @author night
 * @date 2021-08-09
 */
public class SmsConvector {
	public static SmsCacheBO toDO(SmsAggregate smsAggregate) {
		SmsCacheBO smsCacheBO = new SmsCacheBO(smsAggregate.getMobile(), smsAggregate.getSmsCode(), smsAggregate.getSmsType().getSmsTypeCode());
		return smsCacheBO;
	}
}
