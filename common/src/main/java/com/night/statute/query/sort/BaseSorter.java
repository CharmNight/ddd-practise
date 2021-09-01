package com.night.statute.query.sort;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.night.statute.query.sort.SorterOrder;
import org.springframework.validation.annotation.Validated;

/**
 * 由于现在仅有单列排序 排序 所以仅有该类
 * <p>
 * 请注意 {@link SorterOrder} 排序时的顺序必须只能 为ascend 和 descend 亦或null
 *
 * @author night
 * @version 0.0.1
 * @since 0.0.1
 */
@Validated
public class BaseSorter implements SortInterface {

	/**
	 * 排序方式
	 */
	@JsonProperty("order")
	@SorterOrder
	private String order = null;

	/**
	 * 排序字段
	 */
	@JsonProperty("field")
	private String field = null;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}