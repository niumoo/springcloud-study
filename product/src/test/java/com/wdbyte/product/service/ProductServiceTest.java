package com.wdbyte.product.service;

import com.wdbyte.product.dto.CartDTO;
import com.wdbyte.product.dataobject.ProductInfo;
import com.wdbyte.product.repository.ProductInfoRepositoryTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<ProductInfo> productInfoList = productService.findByProductId(list);
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void decreaseStock() {
        List<CartDTO> cartDtoList = new ArrayList<>();
        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId("157875196366160022");
        cartDTO.setProductQuantity(2);

        CartDTO cartDTO2 = new CartDTO();
        cartDTO2.setProductId("1578751963661600222");
        cartDTO2.setProductQuantity(2);

        cartDtoList.add(cartDTO);
        cartDtoList.add(cartDTO2);
        productService.decreaseStock(cartDtoList);
    }
}