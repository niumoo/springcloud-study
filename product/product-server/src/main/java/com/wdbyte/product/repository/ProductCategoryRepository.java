package com.wdbyte.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdbyte.product.dataobject.ProductCategory;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 20:55
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
