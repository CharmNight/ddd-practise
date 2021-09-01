package com.night.statute.query.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.night.statute.query.BaseQuery;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 *
 * 基础搜索类 {@link BaseQuery}
 *
 * 根据单一列表进行筛选
 *
 * @author night
 *
 * @since 0.0.1
 * @version 0.0.1
 */
@Getter
@Setter
@Validated
public class OneFieldBaseSearch implements SearchInterface {
	/**
	 * 搜索的列， 具体接口和前端进行对接
	 */
	@JsonProperty("key")
	private List<String> key;

	/**
	 * 搜索的内容
	 */
	@JsonProperty("values")
	private String values;
}