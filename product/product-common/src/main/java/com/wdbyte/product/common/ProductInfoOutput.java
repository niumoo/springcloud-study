package com.wdbyte.product.common;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/14 15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoOutput {
    /** ID。 */
    private String productId;

    /** 名字。 */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

}
