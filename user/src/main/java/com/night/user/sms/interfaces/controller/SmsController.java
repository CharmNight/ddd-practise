package com.night.user.sms.interfaces.controller;

import com.night.api.user.sms.SmsApi;
import com.night.model.user.sms.request.VerificationCodeRequest;
import com.night.user.sms.application.command.SmsApplication;
import com.night.user.sms.interfaces.assembler.AssemblerFactory;
import com.night.user.sms.interfaces.assembler.sms.SmsRequestAssembler;
import com.night.user.sms.interfaces.dto.VerificationCodeDTO;
import com.night.statute.SuccessResponse;
import com.night.statute.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author night
 * @date 2021-08-09
 */
@Validated
@RestController
public class SmsController implements SmsApi {

	@Autowired
	private SmsApplication smsApplication;

	@Override
	public ResponseEntity<BaseResponse> sendSms(@Valid @RequestBody VerificationCodeRequest request) {
		VerificationCodeDTO verificationCodeDTO = new AssemblerFactory().convert(new SmsRequestAssembler(), request, VerificationCodeDTO.class);
		smsApplication.sendSms(verificationCodeDTO);

		return ResponseEntity.ok(SuccessResponse.success());
	}
}
