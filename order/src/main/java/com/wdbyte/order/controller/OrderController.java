package com.wdbyte.order.controller;

import com.wdbyte.order.VO.ResultVO;
import com.wdbyte.order.converter.OrderForm2OrderDTO;
import com.wdbyte.order.dto.OrderDTO;
import com.wdbyte.order.enums.ResultEnum;
import com.wdbyte.order.exception.OrderException;
import com.wdbyte.order.form.OrderForm;
import com.wdbyte.order.service.OrderService;
import com.wdbyte.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/11 8:43
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /***
     * 1. 参数校验
     * 2. 查询商品信息（调用商品服务）
     * 3. 计算总价
     * 4. 扣除库存
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确,orderForm={} ", orderForm);
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), message);
        }
        // OrderForm -> OrderDTO
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

}
