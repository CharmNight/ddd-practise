package com.night.user.sms.infrastructure.repository.cache;

import com.alibaba.fastjson.JSON;
import com.night.model.user.enums.SMSTypeEnum;
import com.night.user.sms.domain.aggregate.SmsAggregate;
import com.night.user.sms.infrastructure.repository.bo.SmsCacheBO;
import com.night.user.sms.infrastructure.repository.convector.SmsConvector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author night
 * @date 2021-08-09
 */
@Component
public class SmsCache {

	private final String LOGIN_KEY = "";
	private final String UPDATE_PWD_KEY = "";
	private final String BIND_WECHAT_KEY = "";
	private final String UNBIND_WECHAT_Key = "";

	@Autowired
	private RedisTemplate redisTemplate;


//	/**
//	 * 将验证码存储到Redis中
//	 */
//	public void saveSMS2Redis(String phoneNumber, String verificationCode, int codeType, String key) {
//		String userRedisKey = key + phoneNumber;
//		HashOperations hashOperations = redisTemplate.opsForHash();
//		HashMap<String, Object> smsMap = new HashMap<>();
//		smsMap.put("verificationCode", verificationCode);
//		smsMap.put("code_type", codeType);
//		smsMap.put("state", false);
//		smsMap.put("created_at", dateUtil.getNowTime());
//		hashOperations.putAll(userRedisKey, smsMap);
//		redisTemplate.expire(userRedisKey, 5, TimeUnit.MINUTES);
//	}
//
//	/**
//	 * 验证码1分钟验证
//	 * 一个手机号一分钟内仅可发送一次短信
//	 * @return
//	 */
//	public boolean oneMinuteAgo(String phoneNumber, String key) {
//		String userRedisKey = key + phoneNumber;
//		HashOperations hashOperations = redisTemplate.opsForHash();
//		HashMap map = (HashMap) hashOperations.entries(userRedisKey);
//		if (map.size() == 0) {
//			return true;
//		}
//		DateUtil dateUtil = new DateUtil();
//		return !dateUtil.twoTimeComparison(dateUtil.getNowTime(), dateUtil.operatingTime(String.valueOf(map.get("created_at")), 1, Calendar.MINUTE));
//	}
//	public boolean getSMS2Redis(String phone, String verificationCode, int type, String key){
//		String userRedisKey = key + phone;
//
//		HashOperations hashOperations = redisTemplate.opsForHash();
//		HashMap map = (HashMap) hashOperations.entries(userRedisKey);
//
//		if (map.size()==0) {
//			return false;
//		}
//		boolean sms_state = map.get("state").equals("true");
//		String sms_code = (String) map.get("verificationCode");
//		int sms_type = (int) map.get("code_type");
//
//		if (sms_type==type && verificationCode.equals(sms_code) && !sms_state) {
//			hashOperations.getOperations().delete(userRedisKey);
//			return true;
//		}
//		return false;
//
//	}
//
//
//	public boolean getSMS2Redis(String verificationId, String verificationCode){
//		if (verificationId == null || verificationCode == null) {
//			return false;
//		}
//
//		ValueOperations valueOperations = redisTemplate.opsForValue();
//		String userRedisKey = "SYS:verificationId:" + verificationId;
//
//		String code = String.valueOf(valueOperations.get(userRedisKey)).toLowerCase().trim();
//		if (code.equals(verificationCode.toLowerCase().trim())) {
//			valueOperations.getOperations().delete(userRedisKey);
//			return true;
//		}
//		return false;
//	}


	/**
	 * 检查是否超时
	 * 一个手机号一分钟内仅可发送一次短信
	 *
	 * @param smsAggregate
	 *
	 * @return True 超时
	 * False 未超时
	 */
	public Boolean checkOutTime(SmsAggregate smsAggregate) {
		SmsCacheBO smsCacheBO = SmsConvector.toDO(smsAggregate);
		String redisKey = doGetRedisKey(smsCacheBO);
		HashOperations hashOperations = redisTemplate.opsForHash();
		HashMap map = (HashMap) hashOperations.entries(redisKey);
		if (map.size() == 0) {
			return true;
		}
		smsCacheBO = JSON.parseObject(JSON.toJSONString(map), SmsCacheBO.class);
		return smsCacheBO.getCreatedAt() + 60 > System.currentTimeMillis();
	}

	/**
	 * 获取Redis 的key
	 *
	 * @param smsCacheBO
	 *
	 * @return
	 */
	public String doGetRedisKey(SmsCacheBO smsCacheBO) {
		if (smsCacheBO.getCodeType().equals(SMSTypeEnum.LOGIN.getSmsTypeCode())) {
			return LOGIN_KEY;
		}
		return "";
	}

	/**
	 * 存储
	 *
	 * @param smsAggregate
	 */
	public void saveSms(SmsAggregate smsAggregate) {
		SmsCacheBO smsCacheBO = SmsConvector.toDO(smsAggregate);
		String redisKey = doGetRedisKey(smsCacheBO);
		HashOperations hashOperations = redisTemplate.opsForHash();
		hashOperations.putAll(redisKey, smsCacheBO.toMap());
		redisTemplate.expire(redisKey, 5, TimeUnit.MINUTES);
	}
}
