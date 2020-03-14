package com.wdbyte.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdbyte.product.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:18
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVoList;

}
