package com.night.statute.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.night.statute.query.filter.FilterInterface;
import com.night.statute.query.search.SearchInterface;
import com.night.statute.query.sort.BaseSorter;
import com.night.statute.query.sort.SortInterface;
import com.night.statute.response.BaseResponse;
import org.springframework.validation.annotation.Validated;

/**
 *
 *
 * 返回结果的过滤器控制信息
 *
 * 在Response中使用时 参考{@link BaseResponse}
 *
 * 在 Request 中使用时 请如下使用
 * <code>
 *     public class xxxRequest{
 *         @JsonProperty("query")
 *         private BaseQuery query;
 *         @JsonProperty("id")
 *         private Long id;
 *     }
 * </code>
 *
 * @author night
 *
 * @since 0.0.1
 * @version 0.0.1
 */
@Validated
public class BaseQuery<Sort extends SortInterface, Search extends SearchInterface, Filter extends FilterInterface> implements QueryInterface {

	/**
	 * 排序
	 */
	@JsonProperty("sorter")
	private Sort sorter = null;

	/**
	 * 搜索
	 */
	@JsonProperty("search")
	private Search search = null;

	/**
	 * 筛选
	 */
	@JsonProperty("filter")
	private Filter filter = null;

	@Override
	public String toString() {
		return "BaseQuery{" +
				"sorter=" + sorter +
				", Search=" + search +
				", Filter=" + filter +
				'}';
	}

	public Sort getSorter() {
		return sorter;
	}

	public void setSorter(Sort sorter) {
		this.sorter = sorter;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
}