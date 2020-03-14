package com.wdbyte.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdbyte.product.dataobject.ProductInfo;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 20:24
 */
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);

}
