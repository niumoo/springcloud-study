package com.wdbyte.product.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * <p>
 * 商品类目表
 *
 * @author niujinpeng
 * @Date 2020/3/7 20:52
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private int categoryId;

    /** 类目名称 */
    private String categoryName;

    /** 类目编号 */
    private int categoryType;

    private Date createTime;

    private Date updateTime;
}
