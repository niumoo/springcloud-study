package com.wdbyte.product.controller;

import com.wdbyte.product.dto.CartDTO;
import com.wdbyte.product.VO.ProductInfoVO;
import com.wdbyte.product.VO.ProductVO;
import com.wdbyte.product.VO.ResultVO;
import com.wdbyte.product.dataobject.ProductCategory;
import com.wdbyte.product.dataobject.ProductInfo;
import com.wdbyte.product.service.CategoryService;
import com.wdbyte.product.service.ProductService;
import com.wdbyte.product.utils.ResultV0Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品服务
 *
 * @author niujinpeng
 * @Date 2020/3/7 15:02
 */
@RestController
@RequestMapping("/product")
public class PorductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架的商品
     * 2。 查询类目 Type 列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        // 1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 2。 查询类目 Type 列表
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        // 3.查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        // 4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVoList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultV0Util.success(productVOList);
    }

    /**
     * 根据商品ID查询商品列表(给订饭服务调用)
     * 
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> findByProductId(@RequestBody List<String> productIdList) {
        return productService.findByProductId(productIdList);
    }

    /**
     * 减少库存
     * 
     * @param cartDTOList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        productService.decreaseStock(cartDTOList);
    }

}
