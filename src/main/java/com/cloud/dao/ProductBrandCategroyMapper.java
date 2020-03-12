package com.cloud.dao;

import com.cloud.entity.ProductBrandCategroy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBrandCategroyMapper {

    ProductBrandCategroy queryById(@Param(value = "uuid") String uuid);

    List<ProductBrandCategroy> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<ProductBrandCategroy> queryAll(ProductBrandCategroy productBrandCategroy);

    int insert(ProductBrandCategroy productBrandCategroy);

    int update(ProductBrandCategroy productBrandCategroy);

    int deleteById(String uuid);

}