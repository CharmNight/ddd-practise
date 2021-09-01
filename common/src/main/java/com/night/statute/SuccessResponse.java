package com.night.statute;

import com.night.statute.pagination.PageResult;
import com.night.statute.query.BaseQuery;
import com.night.statute.response.BaseQueryResponse;
import com.night.statute.response.BaseResponse;

/**
 * @author night
 * @date 2021-08-09
 */
public class SuccessResponse {

	public static <T> BaseResponse<T> success() {
		BaseResponse<T> response = new BaseResponse<>();
		response.setStatusCode(200);
		return response;
	}

	public static <T> BaseResponse<T> success(T data) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setStatusCode(200);
		response.setData(data);
		return response;
	}

	public static <T> BaseResponse<T> success(PageResult pageResult, T data) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setPagination(pageResult);
		response.setStatusCode(200);
		response.setData(data);
		return response;
	}

	public static <T, Q extends BaseQuery> BaseQueryResponse<T, Q> success(T data, Q query) {
		BaseQueryResponse<T, Q> response = new BaseQueryResponse<>();
		response.setStatusCode(200);
		response.setQuery(query);
		response.setData(data);
		return response;
	}

	public static <T, Q extends BaseQuery> BaseQueryResponse<T, Q> success(T data, Q query, PageResult pagination) {
		BaseQueryResponse<T, Q> response = new BaseQueryResponse<>();
		response.setPagination(pagination);
		response.setStatusCode(200);
		response.setQuery(query);
		response.setData(data);
		return response;
	}

}
