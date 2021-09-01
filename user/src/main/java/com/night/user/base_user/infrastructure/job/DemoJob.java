package com.night.user.base_user.infrastructure.job;

import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author night
 * @date 2021-08-12
 */

@Component
public class DemoJob extends IJobHandler {

	@Override
	@XxlJob(value = "TaskDemo")
	public void execute() throws Exception {
		System.out.println("hello");
	}
}
