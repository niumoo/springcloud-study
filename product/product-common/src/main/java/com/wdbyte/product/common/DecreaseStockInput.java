package com.wdbyte.product.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 减少库存入参
 *
 * @author niujinpeng
 * @Date 2020/3/14 15:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecreaseStockInput {

    /** 商品ID */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

}
