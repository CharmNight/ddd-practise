package com.night.sms.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ali sms 开关
 * @author night
 * @date 2021-08-16
 */
@Configuration
@EnableConfigurationProperties(AliSmsConfig.class)
@ConditionalOnBean(AliSmsMarkerConfiguration.class)
public class AliSmsAutoConfiguration {

}
