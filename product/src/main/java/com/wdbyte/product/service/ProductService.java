package com.wdbyte.product.service;

import com.wdbyte.product.dto.CartDTO;
import com.wdbyte.product.dataobject.ProductInfo;

import java.util.List;

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
    List<ProductInfo> findByProductId(List<String> productIdList);

    /**
     * 减少库存
     * 
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
