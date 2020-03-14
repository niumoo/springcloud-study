package com.wdbyte.product.enums;

import lombok.Getter;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/13 21:37
 */
@Getter
public enum ResultEnum {

    /***/
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    /***/
    PRODUCT_STOCK_ERROR(2, "商品库存不足"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
