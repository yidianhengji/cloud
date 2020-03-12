package com.cloud.service;

import com.cloud.entity.Product;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductService {

    Product queryById(String uuid);

    List<Product> queryAllByLimit(int offset, int limit);

    Product insert(Product product);

    Product update(Product product);

    boolean deleteById(String uuid);

    Page<Product> queryAll(Product product);
}