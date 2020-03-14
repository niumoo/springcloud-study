package com.wdbyte.product.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wdbyte.product.common.DecreaseStockInput;
import com.wdbyte.product.common.ProductInfoOutput;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/13 8:07
 */
@FeignClient(name = "PRODUCT")
public interface ProductClient {

    /**
     * 通过商品ID查询商品列表
     * 
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> findByProductId(@RequestBody List<String> productIdList);

    /**
     * 减少库存
     *
     * @param decreaseStockInputList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
