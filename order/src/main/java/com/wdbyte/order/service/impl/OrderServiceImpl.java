package com.wdbyte.order.service.impl;

import com.netflix.discovery.converters.Auto;
import com.wdbyte.order.client.ProductClient;
import com.wdbyte.order.dataobject.OrderDetail;
import com.wdbyte.order.dataobject.OrderMaster;
import com.wdbyte.order.dataobject.ProductInfo;
import com.wdbyte.order.dto.CartDTO;
import com.wdbyte.order.dto.OrderDTO;
import com.wdbyte.order.enums.OrderStatusEnum;
import com.wdbyte.order.enums.PayStatusEnum;
import com.wdbyte.order.repository.OrderDetailRepository;
import com.wdbyte.order.repository.OrderMasterRepository;
import com.wdbyte.order.service.OrderService;
import com.wdbyte.order.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 21:24
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    /**
     * 1. 查询商品信息（调用商品服务）
     * 2. 计算总价
     * 3. 扣除库存（调用商品服务
     * 4. 订单入库
     * 
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderMasterId = KeyUtil.getUniqueKey();
        // 1. 查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList()
                .stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.findByProductId(productIdList);

        // 2. 计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    // 计算价格
                    BigDecimal productPrice = productInfo.getProductPrice();
                    Integer productQuantity = orderDetail.getProductQuantity();
                    orderAmount = productPrice.multiply(BigDecimal.valueOf(productQuantity)).add(orderAmount);
                    // 订单详情入库
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderMasterId);
                    orderDetail.setDetailId(KeyUtil.getUniqueKey());
                    orderDetailRepository.save(orderDetail);
                    log.info("【订单详情】订单详情入库={}", orderDetail);
                }
            }
        }

        // 3. 扣除库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList()
                .stream()
                .map(orderDetail -> new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        // 4. 订单入库
        orderDTO.setOrderId(orderMasterId);
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderAmount(new BigDecimal(11));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
