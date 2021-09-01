package com.night.statute.query.search;

/**
 *
 * 多列搜索 上级Filter见 {@link BaseQuery}
 * 所有筛选必须遵守以下格式 <br/>
 * {
 *  key1: val1,
 *  key2: val2,
 * }
 * <p>
 * 例如
 * 某个列表页 需要根据用户姓名和手机号分别进行搜索，nickname这个字段所传的值 就是搜索的值
 * <code>
 * public class UserListFilter extends AbstractFilter{
 *  private String nickname;
 *  private String phone;
 * }
 * </code>
 *
 * @author night
 *
 * @since 0.0.1
 * @version 0.0.1
 */
public interface MoreFieldBaseSearchInterface extends SearchInterface {

}