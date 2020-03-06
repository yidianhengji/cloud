package com.cloud.service;

import com.cloud.entity.ProductCategory;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory queryById(String uuid);

    List<ProductCategory> queryAllByLimit(int offset, int limit);

    ProductCategory insert(ProductCategory productCategory);

    ProductCategory update(ProductCategory productCategory);

    boolean deleteById(String uuid);

    Page<ProductCategory> queryAll(ProductCategory productCategory);

    List<ProductCategory> queryTree(ProductCategory productCategory);

}