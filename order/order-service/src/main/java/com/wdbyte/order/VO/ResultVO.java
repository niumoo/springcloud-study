package com.wdbyte.order.VO;

import lombok.Data;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 22:05
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
