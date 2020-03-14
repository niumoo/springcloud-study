package com.wdbyte.product.service.impl;

import java.util.List;
import java.util.Optional;

import com.wdbyte.product.dto.CartDTO;
import com.wdbyte.product.enums.ResultEnum;
import com.wdbyte.product.exception.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdbyte.product.dataobject.ProductInfo;
import com.wdbyte.product.enums.ProductStatusEnum;
import com.wdbyte.product.repository.ProductInfoRepository;
import com.wdbyte.product.service.ProductService;
import org.springframework.transaction.annotation.Transactional;

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
    public List<ProductInfo> findByProductId(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> optionalProduct = productInfoRepository.findById(cartDTO.getProductId());
            // 商品不存在
            if (!optionalProduct.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = optionalProduct.get();
            // 商品库存不足
            int result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
