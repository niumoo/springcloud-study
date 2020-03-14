package com.wdbyte.product.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wdbyte.product.dataobject.ProductInfo;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 20:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findByProductIdList() {
        List<String> list = Arrays.asList("157875196366160022", "157875227953464068");
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(list);
        Assert.assertTrue(productInfoList.size() > 0);
    }
}