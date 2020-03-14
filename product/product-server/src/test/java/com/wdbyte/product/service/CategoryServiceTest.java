package com.wdbyte.product.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wdbyte.product.dataobject.ProductCategory;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(productCategoryList.size() > 0);
    }
}