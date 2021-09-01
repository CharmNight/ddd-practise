package com.night.user.sms.domain.vo;

import java.util.concurrent.TimeUnit;

/**
 * @author night
 * @date 2021-08-09
 */
public class OutTimeVO {
	/**
	 * 默认发送超时时间 1
	 */
	private final Integer DEFAULT_SEND_OUT_TIME = 1;
	/**
	 * 默认存储超时时间 5
	 */
	private final Integer DEFAULT_SAVE_OUT_TIME = 5;

	private Integer outTime;
	private TimeUnit timeUnit;

	public OutTimeVO() {
		this.outTime = DEFAULT_SEND_OUT_TIME;
		this.timeUnit = TimeUnit.MINUTES;
	}

	public OutTimeVO(Integer outTime, TimeUnit timeUnit) {
		this.outTime = outTime;
		this.timeUnit = timeUnit;
	}
}
