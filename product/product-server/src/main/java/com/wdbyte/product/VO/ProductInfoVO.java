package com.wdbyte.product.VO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:20
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("descpriton")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
