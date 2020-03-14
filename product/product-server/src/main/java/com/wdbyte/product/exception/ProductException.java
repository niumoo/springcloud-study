package com.wdbyte.product.exception;

import com.wdbyte.product.enums.ResultEnum;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/13 21:36
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
