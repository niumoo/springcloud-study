package com.wdbyte.order.exception;

import com.wdbyte.order.enums.ResultEnum;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 21:40
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
