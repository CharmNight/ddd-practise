package com.night.statute.query.search;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * 基础搜索类 {@link BaseQuery}
 * <p>
 * 无搜索， 仅用于占位
 *
 * @author night
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
@Validated
public class NotBaseSearch implements SearchInterface {
}