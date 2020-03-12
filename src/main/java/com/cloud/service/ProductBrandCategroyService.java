package com.cloud.service;

import com.cloud.entity.ProductBrandCategroy;

import java.util.List;

public interface ProductBrandCategroyService {

    ProductBrandCategroy queryById(String uuid);

    List<ProductBrandCategroy> queryAllByLimit(int offset, int limit);

    ProductBrandCategroy insert(ProductBrandCategroy productBrandCategroy);

    ProductBrandCategroy update(ProductBrandCategroy productBrandCategroy);

    boolean deleteById(String uuid);

    List<ProductBrandCategroy> queryAll(ProductBrandCategroy productBrandCategroy);
}