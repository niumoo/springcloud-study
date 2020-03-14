package com.wdbyte.order.service;

import com.wdbyte.order.dto.OrderDTO;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/11 8:45
 */
public interface OrderService {



    /**
     * 创建订单
     * 
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
