package com.wdbyte.order.converter;

import com.alibaba.fastjson.JSON;
import com.wdbyte.order.dataobject.OrderDetail;
import com.wdbyte.order.dto.OrderDTO;
import com.wdbyte.order.enums.ResultEnum;
import com.wdbyte.order.exception.OrderException;
import com.wdbyte.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 21:45
 */
@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        try {
            String items = orderForm.getItems();
            List<OrderDetail> orderDetails = JSON.parseArray(items, OrderDetail.class);
            orderDTO.setOrderDetailList(orderDetails);
        } catch (Exception e) {
            log.error("【JSON转换】,JSON转换异常，orderForm.items={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        return orderDTO;
    }
}
