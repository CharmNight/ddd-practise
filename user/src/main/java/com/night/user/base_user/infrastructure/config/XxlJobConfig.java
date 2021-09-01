package com.night.user.base_user.infrastructure.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class XxlJobConfig {
	private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${xxl.job.admin.service}")
	private String service;

	@Value("${xxl.job.admin.addresses}")
	private String adminAddresses;

	@Value("${xxl.job.accessToken: }")
	private String accessToken;

	@Value("${xxl.job.executor.appname}")
	private String appname;

	@Value("${xxl.job.executor.address}")
	private String address;

	@Value("${xxl.job.executor.ip}")
	private String ip;

	@Value("${xxl.job.executor.port}")
	private int port;

	@Value("${xxl.job.executor.logpath}")
	private String logPath;

	@Value("${xxl.job.executor.logretentiondays}")
	private int logRetentionDays;

	/**
	 * 根据服务名称获取地址
	 * @param serviceName
	 * @return
	 */
	public String getServicePort(String serviceName) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		if (CollectionUtils.isEmpty(instances)) {
			return "";
		}
		if (instances.size() >= 2) {
			return instances.stream().map(item -> {
				return "http://" + item.getHost() + ":" + item.getPort();
			}).collect(Collectors.joining(","));
		}
		ServiceInstance serviceInstance = instances.get(0);
		return "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();

	}


	@Bean
	public XxlJobSpringExecutor xxlJobExecutor() {
		logger.info(">>>>>>>>>>> xxl-job config init.");
		String servicePort = getServicePort(service);
		XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
		xxlJobSpringExecutor.setAdminAddresses(servicePort + adminAddresses);
		xxlJobSpringExecutor.setAppname(appname);
		xxlJobSpringExecutor.setAddress(address);
		xxlJobSpringExecutor.setIp(ip);
		xxlJobSpringExecutor.setPort(port);
//        xxlJobSpringExecutor.setAccessToken(accessToken);
		xxlJobSpringExecutor.setLogPath(logPath);
		xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);

		return xxlJobSpringExecutor;
	}

}