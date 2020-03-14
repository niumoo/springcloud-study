package com.wdbyte.order.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.wdbyte.order.OrderApplicationTests;
import com.wdbyte.order.dataobject.OrderDetail;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/11 8:40
 */
@Component
class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123");
        orderDetail.setOrderId("123");
        orderDetail.setProductIcon("http://xxx.com/a.jpg");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("豆腐");
        orderDetail.setProductPrice(new BigDecimal(0.1));
        orderDetail.setProductQuantity(3);
        OrderDetail detail = orderDetailRepository.save(orderDetail);
        Assert.isTrue(detail != null, "order detail save error ");
    }

}