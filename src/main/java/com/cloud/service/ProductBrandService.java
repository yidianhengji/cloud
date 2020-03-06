package com.cloud.service;

import com.cloud.entity.ProductBrand;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductBrandService {

    ProductBrand queryById(String uuid);

    List<ProductBrand> queryAllByLimit(int offset, int limit);

    ProductBrand insert(ProductBrand productBrand);

    ProductBrand update(ProductBrand productBrand);

    boolean deleteById(String uuid);

    Page<ProductBrand> queryAll(ProductBrand productBrand);
}