package com.wdbyte.order.dto;

import com.wdbyte.order.dataobject.OrderDetail;
import lombok.Data;
import org.hibernate.validator.constraints.EAN;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/11 21:16
 */
@Data
public class OrderDTO {

    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 订单详情 **/
    private List<OrderDetail> orderDetailList;

}
