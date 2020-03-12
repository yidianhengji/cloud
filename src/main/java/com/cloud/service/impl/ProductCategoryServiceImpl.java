package com.cloud.service.impl;

import com.cloud.dao.ProductCategoryMapper;
import com.cloud.entity.ProductCategory;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductCategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryMapper productCategoryDao;

    @Override
    public ProductCategory queryById(String uuid) {
        return this.productCategoryDao.queryById(uuid);
    }

    @Override
    public List<ProductCategory> queryAllByLimit(int offset, int limit) {
        return this.productCategoryDao.queryAllByLimit(offset, limit);
    }

    @Override
    public ProductCategory insert(ProductCategory productCategory) {
        productCategory.setUuid(UUID.randomUUID().toString().replace("-", ""));
        productCategory.setModifyTime(new Date());
        productCategory.setCreateTime(new Date());
        this.productCategoryDao.insert(productCategory);
        return productCategory;
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        if (StringUtil.isEmpty(productCategory.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        productCategory.setModifyTime(new Date());
        this.productCategoryDao.update(productCategory);
        return this.queryById(productCategory.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.productCategoryDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<ProductCategory> queryAll(ProductCategory productCategory) {
        if (productCategory.getPageSize() != null && productCategory.getPageNum() != null) {
            PageHelper.startPage(productCategory.getPageNum(), productCategory.getPageSize());
        }
        Page<ProductCategory> pages = this.productCategoryDao.queryAll(productCategory);
        return pages;
    }

    @Override
    public List<ProductCategory> queryTree(ProductCategory productCategory) {
        List<ProductCategory> list = this.productCategoryDao.queryAll(productCategory);
        List<ProductCategory> listTree = getChilds(list, "0");
        return listTree;
    }

    @Override
    public List<ProductCategory> queryFindCategoryId(String categoryId) {
        return this.productCategoryDao.queryFindCategoryId(categoryId);
    }

    public List<ProductCategory> getChilds(List<ProductCategory> list, String parent) {
        List<ProductCategory> listTree = new ArrayList<ProductCategory>();
        for (ProductCategory productCategory : list) {
            String uuid = productCategory.getUuid();
            String categoryId = productCategory.getCategoryId();
            if (parent.equals(categoryId)) {
                List<ProductCategory> productCategoryList = getChilds(list, uuid);
                productCategory.setChilds(productCategoryList);
                listTree.add(productCategory);
            }
        }
        return listTree;
    }
}