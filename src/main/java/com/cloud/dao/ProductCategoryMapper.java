package com.cloud.dao;

import com.cloud.entity.ProductCategory;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductCategoryMapper {

    ProductCategory queryById(@Param(value="uuid")String uuid);

    List<ProductCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<ProductCategory> queryAll(ProductCategory productCategory);

    int insert(ProductCategory productCategory);

    int update(ProductCategory productCategory);

    int deleteById(String uuid);

}