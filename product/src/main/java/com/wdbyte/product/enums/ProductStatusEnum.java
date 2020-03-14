package com.wdbyte.product.enums;

import lombok.Getter;

/**
 * <p>
 * 商品上下架状态
 * 
 * @author niujinpeng
 * @Date 2020/3/7 21:02
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"),
    /***/
    DOWN(1, "下架"),;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
