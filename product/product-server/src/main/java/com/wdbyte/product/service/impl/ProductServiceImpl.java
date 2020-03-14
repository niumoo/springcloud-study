package com.wdbyte.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdbyte.product.common.DecreaseStockInput;
import com.wdbyte.product.common.ProductInfoOutput;
import com.wdbyte.product.dataobject.ProductInfo;
import com.wdbyte.product.enums.ProductStatusEnum;
import com.wdbyte.product.enums.ResultEnum;
import com.wdbyte.product.exception.ProductException;
import com.wdbyte.product.repository.ProductInfoRepository;
import com.wdbyte.product.service.ProductService;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:01
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findByProductId(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList)
                .stream()
                .map(productInfo -> {
                    ProductInfoOutput productInfoOutput = new ProductInfoOutput();
                    BeanUtils.copyProperties(productInfo,productInfoOutput);
                    return productInfoOutput;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> optionalProduct = productInfoRepository.findById(decreaseStockInput.getProductId());
            // 商品不存在
            if (!optionalProduct.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = optionalProduct.get();
            // 商品库存不足
            int result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
