package com.night.statute.request;

import com.night.statute.pagination.PageResult;
import com.night.statute.query.BaseQuery;

/**
 * @author night
 * @date 2021-08-06
 */
public class CommonRequest implements Request {

	private BaseQuery query;

	private PageResult pageResult;

	public BaseQuery getQuery() {
		return query;
	}

	public void setQuery(BaseQuery query) {
		this.query = query;
	}

	public PageResult getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}

}
