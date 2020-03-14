package com.wdbyte.product.service.impl;

import com.wdbyte.product.dataobject.ProductCategory;
import com.wdbyte.product.repository.ProductCategoryRepository;
import com.wdbyte.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:13
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
