package com.night.statute.query;

import com.night.statute.query.filter.FilterInterface;
import com.night.statute.query.search.SearchInterface;
import com.night.statute.query.sort.BaseSorter;
import com.night.statute.query.sort.SortInterface;

/**
 *
 * 返回结果的过滤器控制信息的根
 *
 * @author night
 *
 * @since 0.0.1
 * @version 0.0.1
 */
public interface QueryInterface {
	SortInterface sorter = null;
	SearchInterface search = null;
	FilterInterface filter = null;
}