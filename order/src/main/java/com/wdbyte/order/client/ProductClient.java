package com.wdbyte.order.client;

import com.wdbyte.order.dataobject.ProductInfo;
import com.wdbyte.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/13 8:07
 */
@FeignClient(name = "PRODUCT")
public interface ProductClient {

    @GetMapping(value = "/msg")
    String msg();


    /**
     * 通过商品ID查询商品列表
     * 
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfo> findByProductId(@RequestBody List<String> productIdList);

    /**
     * 减少库存
     *
     * @param cartDTOList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
