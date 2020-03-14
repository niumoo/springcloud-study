package com.wdbyte.order.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * <p>
 *
 * 前端传过来的参数
 * 
 * @author niujinpeng
 * @Date 2020/3/12 21:35
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 卖家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信 openid
     */
    @NotEmpty(message = "openId必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
