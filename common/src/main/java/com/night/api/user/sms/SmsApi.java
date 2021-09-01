package com.night.api.user.sms;

import com.night.model.user.sms.request.VerificationCodeRequest;
import com.night.statute.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author night
 * @date 2021-08-09
 */
public interface SmsApi {
	@RequestMapping(
			value = {"/api/v200/user/sms/send/"},
			produces = {"application/json"},
			consumes = {"application/json"},
			method = {RequestMethod.POST}
	)
	ResponseEntity<BaseResponse> sendSms(@Valid @RequestBody VerificationCodeRequest request);

}
