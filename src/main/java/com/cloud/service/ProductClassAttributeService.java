package com.cloud.service;

import com.cloud.entity.ProductClassAttribute;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductClassAttributeService {

    ProductClassAttribute queryById(String uuid);

    List<ProductClassAttribute> queryAllByLimit(int offset, int limit);

    ProductClassAttribute insert(ProductClassAttribute productClassAttribute);

    ProductClassAttribute update(ProductClassAttribute productClassAttribute);

    boolean deleteById(String uuid);

    Page<ProductClassAttribute> queryAll(ProductClassAttribute productClassAttribute);
}