package com.night.statute.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.night.statute.query.BaseQuery;

public class BaseQueryResponse<Data, Query extends BaseQuery> extends BaseResponse<Data> {

	@JsonProperty("query")
	private Query query = null;

	public BaseQueryResponse query(Query query) {
		this.query = query;
		return this;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	@Override
	public String toString() {

		return "BaseQueryResponse{" +
				"query=" + query +
				"statusCode=" + getStatusCode() +
				", data=" + getData() +
				", message='" + getMessage() + '\'' +
				", pagination=" + getPagination() +
				'}';
	}
}