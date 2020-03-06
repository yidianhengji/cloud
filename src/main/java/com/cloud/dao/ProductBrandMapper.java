package com.cloud.dao;

import com.cloud.entity.ProductBrand;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductBrandMapper {

    ProductBrand queryById(@Param(value="uuid")String uuid);

    List<ProductBrand> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<ProductBrand> queryAll(ProductBrand productBrand);

    int insert(ProductBrand productBrand);

    int update(ProductBrand productBrand);

    int deleteById(String uuid);

}