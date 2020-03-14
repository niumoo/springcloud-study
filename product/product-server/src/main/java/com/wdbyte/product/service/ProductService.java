package com.wdbyte.product.service;

import java.util.List;

import com.wdbyte.product.common.DecreaseStockInput;
import com.wdbyte.product.common.ProductInfoOutput;
import com.wdbyte.product.dataobject.ProductInfo;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:00
 */
public interface ProductService {

    /**
     * 查询所有的在架商品
     * 
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据商品ID查找商品列表
     * 
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findByProductId(List<String> productIdList);

    /**
     * 减少库存
     * 
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
