package com.cloud.service.impl;

import com.cloud.dao.ProductBrandCategroyMapper;
import com.cloud.entity.ProductBrandCategroy;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductBrandCategroyService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ProductBrandCategroyServiceImpl implements ProductBrandCategroyService {
    @Resource
    private ProductBrandCategroyMapper productBrandCategroyDao;

    @Override
    public ProductBrandCategroy queryById(String uuid) {
        return this.productBrandCategroyDao.queryById(uuid);
    }

    @Override
    public List<ProductBrandCategroy> queryAllByLimit(int offset, int limit) {
        return this.productBrandCategroyDao.queryAllByLimit(offset, limit);
    }

    @Override
    public ProductBrandCategroy insert(ProductBrandCategroy productBrandCategroy) {
        productBrandCategroy.setUuid(UUID.randomUUID().toString().replace("-", ""));
        this.productBrandCategroyDao.insert(productBrandCategroy);
        return productBrandCategroy;
    }

    @Override
    public ProductBrandCategroy update(ProductBrandCategroy productBrandCategroy) {
        if (StringUtil.isEmpty(productBrandCategroy.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        this.productBrandCategroyDao.update(productBrandCategroy);
        return this.queryById(productBrandCategroy.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.productBrandCategroyDao.deleteById(uuid) > 0;
    }

    @Override
    public List<ProductBrandCategroy> queryAll(ProductBrandCategroy productBrandCategroy) {
        return this.productBrandCategroyDao.queryAll(productBrandCategroy);
    }
}