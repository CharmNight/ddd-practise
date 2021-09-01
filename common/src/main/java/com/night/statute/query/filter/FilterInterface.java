package com.night.statute.query.filter;

import com.night.statute.query.BaseQuery;

/**
 * 基础的筛选格式 上级Filter见 {@link BaseQuery}
 * 所有筛选必须遵守以下格式 <br>
 * {
 * key1: val1,
 * key2: val2,
 * }
 * <p>
 * 例如
 * 某个列表页 需要根据用户性别sex 和 状态进行筛选，
 * <code>
 * public class UserListFilter extends AbstractFilter{
 *  private String sex;
 *  private List<String> status;
 * }
 * </code>
 *
 * @author night
 *
 * @since 0.0.1
 * @version 0.0.1
 */
public interface FilterInterface {
}