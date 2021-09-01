package com.night.user;

import com.night.log.anntion.EnableMyLog;
import com.night.sms.anntion.EnableSmsJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author night
 * @date 2021-08-05
 */
@EnableSmsJob
@EnableMyLog
@SpringBootApplication
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
