package com.wdbyte.order.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * <p>
 * 商品详情表
 *
 * @author niujinpeng
 * @Date 2020/3/7 15:22
 */
// @Table(name = "xxx")

@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;

    /** 名字. */
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

    private Date createTime;

    private Date updateTime;

    // @JsonIgnore
    // public ProductStatusEnum getProductStatusEnum() {
    // return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    // }

}
