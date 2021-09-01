package com.night.statute.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.night.statute.pagination.PageResult;

public class BaseResponse<T> implements Response {

	@JsonProperty("statusCode")
	private Integer statusCode = null;

	@JsonProperty("data")
	private T data = null;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("pagination")
	private PageResult pagination = null;

	public BaseResponse statusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public BaseResponse data(T data) {
		this.data = data;
		return this;
	}

	public BaseResponse message(String message) {
		this.message = message;
		return this;
	}

	public BaseResponse pagination(PageResult pagination) {
		this.pagination = pagination;
		return this;
	}

	public PageResult getPagination() {
		return pagination;
	}

	public void setPagination(PageResult pagination) {
		this.pagination = pagination;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BaseResponse{" +
				"statusCode=" + statusCode +
				", data=" + data +
				", message='" + message + '\'' +
				", pagination=" + pagination +
				'}';
	}
}