package com.night.statute;

import com.night.statute.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

/**
 * 获取 请求的Body数据
 *
 * @author night
 * @date 2020-11-26
 */
public class ResponseBody {
	private static final int SUCCESS_CODE = 200;

	public static <T> T getBody(ResponseEntity<BaseResponse<T>> responseEntity) throws Exception {
		if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			throw new Exception("Http Code Error");
		}
		if (Objects.isNull(responseEntity.getBody())) {
			throw new Exception("Body is null");
		}
		if (!responseEntity.getBody().getStatusCode().equals(SUCCESS_CODE)) {
			// code 不是200 抛出 message
			throw new Exception(responseEntity.getBody().getMessage());
		}
		// 返回body
		return responseEntity.getBody().getData();
	}
}
