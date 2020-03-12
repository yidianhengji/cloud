package com.cloud.dao;

import com.cloud.entity.ProductClassAttribute;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductClassAttributeMapper {

    ProductClassAttribute queryById(@Param(value = "uuid") String uuid);

    List<ProductClassAttribute> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<ProductClassAttribute> queryAll(ProductClassAttribute productClassAttribute);

    int insert(ProductClassAttribute productClassAttribute);

    int update(ProductClassAttribute productClassAttribute);

    int deleteById(String uuid);

}