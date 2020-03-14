package com.wdbyte.order.enums;

import lombok.Data;
import lombok.Getter;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 21:42
 */
@Getter
public enum ResultEnum {
    /***/
    PARAM_ERROR(1, "参数错误"),
    /***/
    CART_EMPTY(2, "购物车不能为空"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
