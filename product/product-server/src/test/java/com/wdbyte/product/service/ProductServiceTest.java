package com.wdbyte.product.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wdbyte.product.common.DecreaseStockInput;
import com.wdbyte.product.common.ProductInfoOutput;
import com.wdbyte.product.dataobject.ProductInfo;
import com.wdbyte.product.repository.ProductInfoRepositoryTest;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:05
 */
@Component
public class ProductServiceTest extends ProductInfoRepositoryTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findById() {
        List<String> list = Arrays.asList("157875196366160022", "157875227953464068");
        List<ProductInfoOutput> productInfoList = productService.findByProductId(list);
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void decreaseStock() {
        List<DecreaseStockInput> decreaseStockInputList = new ArrayList<>();
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput();
        decreaseStockInput.setProductId("157875196366160022");
        decreaseStockInput.setProductQuantity(2);

        DecreaseStockInput decreaseStockInput2 = new DecreaseStockInput();
        decreaseStockInput2.setProductId("1578751963661600222");
        decreaseStockInput2.setProductQuantity(2);

        decreaseStockInputList.add(decreaseStockInput);
        decreaseStockInputList.add(decreaseStockInput2);
        productService.decreaseStock(decreaseStockInputList);
    }
}