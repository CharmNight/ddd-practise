package com.night.user.sms.interfaces.assembler.sms;

import com.night.model.user.enums.SMSTypeEnum;
import com.night.model.user.sms.request.VerificationCodeRequest;
import com.night.user.sms.interfaces.assembler.Assembler;
import com.night.user.sms.interfaces.dto.VerificationCodeDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author night
 * @date 2021-08-09
 */
public class SmsRequestAssembler implements Assembler<VerificationCodeRequest, VerificationCodeDTO> {
	@Override
	public void assemble(VerificationCodeRequest source, VerificationCodeDTO target) {
		BeanUtils.copyProperties(source, target);

		target.setSmsType(SMSTypeEnum.valuesOf(source.getSmsType()));
	}
}
