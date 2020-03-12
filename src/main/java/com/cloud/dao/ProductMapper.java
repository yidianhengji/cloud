package com.cloud.dao;

import com.cloud.entity.Product;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    Product queryById(@Param(value = "uuid") String uuid);

    List<Product> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<Product> queryAll(Product product);

    int insert(Product product);

    int update(Product product);

    int deleteById(String uuid);

}