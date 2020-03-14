package com.wdbyte.product.service;

import java.util.List;

import com.wdbyte.product.dataobject.ProductCategory;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:13
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
