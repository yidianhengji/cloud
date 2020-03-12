package com.cloud.service.impl;

import com.cloud.dao.ProductBrandMapper;
import com.cloud.entity.ProductBrand;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductBrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductBrandServiceImpl implements ProductBrandService {
    @Resource
    private ProductBrandMapper productBrandDao;

    @Override
    public ProductBrand queryById(String uuid) {
        return this.productBrandDao.queryById(uuid);
    }

    @Override
    public List<ProductBrand> queryAllByLimit(int offset, int limit) {
        return this.productBrandDao.queryAllByLimit(offset, limit);
    }

    @Override
    public ProductBrand insert(ProductBrand productBrand) {
        productBrand.setUuid(UUID.randomUUID().toString().replace("-", ""));
        productBrand.setModifyTime(new Date());
        productBrand.setCreateTime(new Date());
        this.productBrandDao.insert(productBrand);
        return productBrand;
    }

    @Override
    public ProductBrand update(ProductBrand productBrand) {
        if (StringUtil.isEmpty(productBrand.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        productBrand.setModifyTime(new Date());
        this.productBrandDao.update(productBrand);
        return this.queryById(productBrand.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.productBrandDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<ProductBrand> queryAll(ProductBrand productBrand) {
        if (productBrand.getPageSize() != null && productBrand.getPageNum() != null) {
            PageHelper.startPage(productBrand.getPageNum(), productBrand.getPageSize());
        }
        Page<ProductBrand> pages = this.productBrandDao.queryAll(productBrand);
        return pages;
    }
}