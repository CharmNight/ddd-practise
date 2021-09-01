package com.night.sms.anntion;

import com.night.sms.config.AliSmsConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author night
 * @date 2021-08-16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AliSmsConfig.class)
public @interface EnableSmsJob {
}
