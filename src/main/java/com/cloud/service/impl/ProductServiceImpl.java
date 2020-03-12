package com.cloud.service.impl;

import com.cloud.dao.ProductMapper;
import com.cloud.entity.Product;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productDao;

    @Override
    public Product queryById(String uuid) {
        return this.productDao.queryById(uuid);
    }

    @Override
    public List<Product> queryAllByLimit(int offset, int limit) {
        return this.productDao.queryAllByLimit(offset, limit);
    }

    @Override
    public Product insert(Product product) {
        product.setUuid(UUID.randomUUID().toString().replace("-", ""));
        product.setModifyTime(new Date());
        product.setCreateTime(new Date());
        this.productDao.insert(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        if (StringUtil.isEmpty(product.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        product.setModifyTime(new Date());
        this.productDao.update(product);
        return this.queryById(product.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.productDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<Product> queryAll(Product product) {
        if (product.getPageSize() != null && product.getPageNum() != null) {
            PageHelper.startPage(product.getPageNum(), product.getPageSize());
        }
        Page<Product> pages = this.productDao.queryAll(product);
        return pages;
    }
}