package com.wdbyte.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/13 21:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    /** 商品ID */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;
}
