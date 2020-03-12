package com.cloud.service.impl;

import com.cloud.dao.ProductClassAttributeMapper;
import com.cloud.entity.ProductClassAttribute;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductClassAttributeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductClassAttributeServiceImpl implements ProductClassAttributeService {

    @Resource
    private ProductClassAttributeMapper productClassAttributeDao;

    @Override
    public ProductClassAttribute queryById(String uuid) {
        return this.productClassAttributeDao.queryById(uuid);
    }

    @Override
    public List<ProductClassAttribute> queryAllByLimit(int offset, int limit) {
        return this.productClassAttributeDao.queryAllByLimit(offset, limit);
    }

    @Override
    public ProductClassAttribute insert(ProductClassAttribute productClassAttribute) {
        productClassAttribute.setUuid(UUID.randomUUID().toString().replace("-", ""));
        productClassAttribute.setModifyTime(new Date());
        productClassAttribute.setCreateTime(new Date());
        this.productClassAttributeDao.insert(productClassAttribute);
        return productClassAttribute;
    }

    @Override
    public ProductClassAttribute update(ProductClassAttribute productClassAttribute) {
        if (StringUtil.isEmpty(productClassAttribute.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        productClassAttribute.setModifyTime(new Date());
        this.productClassAttributeDao.update(productClassAttribute);
        return this.queryById(productClassAttribute.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.productClassAttributeDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<ProductClassAttribute> queryAll(ProductClassAttribute productClassAttribute) {
        if (productClassAttribute.getPageSize() != null && productClassAttribute.getPageNum() != null) {
            PageHelper.startPage(productClassAttribute.getPageNum(), productClassAttribute.getPageSize());
        }
        Page<ProductClassAttribute> pages = this.productClassAttributeDao.queryAll(productClassAttribute);
        return pages;
    }
}