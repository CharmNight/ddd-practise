package com.night.statute.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * 响应结果中的分页控制信息
 *
 * @author night
 * @version 0.0.1
 * @since 0.0.1
 */
@Validated
public class PageResult {
	/**
	 * 结果集总记录数
	 *
	 * @return total
	 **/
	@JsonProperty("total")
	private Long total = null;

	/**
	 * 当前页码数
	 *
	 * @return current
	 **/
	@JsonProperty("current")
	private Integer current = 1;

	/**
	 * 当前页多少条
	 *
	 * @return pageSize
	 **/
	@JsonProperty("pageSize")
	private Integer pageSize = 20;

	public PageResult total(Long total) {
		this.total = total;
		return this;
	}


	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public PageResult current(Integer current) {
		this.current = current;
		return this;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current == null || current < 1 ? 1 : current;
	}

	public PageResult pageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}


	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize == null || pageSize < 1 ? this.pageSize : pageSize;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PageResult pageResult = (PageResult) o;
		return Objects.equals(this.total, pageResult.total) &&
				Objects.equals(this.current, pageResult.current) &&
				Objects.equals(this.pageSize, pageResult.pageSize);
	}

	@Override
	public int hashCode() {
		return Objects.hash(total, current, pageSize);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PageResult {\n");

		sb.append("    total: ").append(toIndentedString(total)).append("\n");
		sb.append("    current: ").append(toIndentedString(current)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}