package com.wdbyte.product.VO;

import lombok.Data;

/**
 * <p>
 * http 请求返回的最外层对象
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:17
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

}
