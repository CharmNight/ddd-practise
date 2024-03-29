package com.night.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.night.sms.config.AliSmsConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 调用阿里服务 工具
 * @author night
 */
@Component
@Configuration
public class AliSmsUtil implements InitializingBean {
	@Resource
	private AliSmsConfig aliSmsConfig;

	private volatile IAcsClient iAcsClient;

	public String sendSms(String templateCode, String phoneNumbers, String verificationCode) throws ClientException {
		return sendSms(templateCode, phoneNumbers, verificationCode, "测试");
	}

	public String sendSms(String templateCode, String phoneNumbers, String verificationCode, String signName) throws ClientException {

		//组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		//使用post提交
		request.setMethod(MethodType.POST);
		//必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
		request.setPhoneNumbers(phoneNumbers);
		//必填:短信签名-可在短信控制台中找到
		request.setSignName(signName);
		//必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
		request.setTemplateCode(templateCode);
		//可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		//友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		request.setTemplateParam("{\"code\":\"" + verificationCode + "\"}");
		/*
		 可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段) request.setSmsUpExtendCode("90997");
		 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者 request.setOutId("yourOutId");
		 请求失败这里会抛ClientException异常
		 */
		SendSmsResponse sendSmsResponse = iAcsClient.getAcsResponse(request);
		if (sendSmsResponse.getCode() != null && "OK".equals(sendSmsResponse.getCode())) {
			//请求成功
			return verificationCode;
		}
		throw new RuntimeException("短信发送失败，请稍后再试");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (Objects.isNull(aliSmsConfig)) {
			throw new RuntimeException("配置项不能为空");
		}
		if (StringUtils.isBlank(aliSmsConfig.getAccessKeyId())) {
			throw new RuntimeException("accessKeyId is null");
		}
		if (StringUtils.isBlank(aliSmsConfig.getAccessKeySecret())) {
			throw new RuntimeException("accessKeySecret is null");
		}
		if (StringUtils.isBlank(aliSmsConfig.getProduct())) {
			throw new RuntimeException("product is null");
		}
		if (StringUtils.isBlank(aliSmsConfig.getDomain())) {
			throw new RuntimeException("domain is null");
		}

		//设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliSmsConfig.getAccessKeyId(),
				aliSmsConfig.getAccessKeySecret());
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", aliSmsConfig.getProduct(), aliSmsConfig.getDomain());
		iAcsClient = new DefaultAcsClient(profile);
	}
}