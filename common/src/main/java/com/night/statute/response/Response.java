package com.night.statute.response;

/**
 * 最基类的Response
 *
 * @author night
 */
public interface Response<T> {
	/**
	 * 返回Data
	 *
	 * @return
	 */
	T getData();
}