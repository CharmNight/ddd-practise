package com.night.statute.query.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Validated
public class OneFileldFilter implements FilterInterface {
    @JsonProperty("key")
    private String key;

    @JsonProperty("values")
    private List<String> status;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}
}