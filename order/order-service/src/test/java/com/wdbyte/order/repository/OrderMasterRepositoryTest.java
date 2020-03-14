package com.wdbyte.order.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wdbyte.order.OrderApplicationTests;
import com.wdbyte.order.dataobject.OrderMaster;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/11 8:31
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(1);
        OrderMaster save = orderMasterRepository.save(orderMaster);
        System.out.println(save.getOrderId());
    }

}