package com.cloud.service.impl;

import com.cloud.dao.ProductDictionaryMapper;
import com.cloud.entity.ProductDictionary;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductDictionaryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 商品字典表(TbProductDictionary)表服务实现类
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@Service
public class ProductDictionaryServiceImpl implements ProductDictionaryService {
    @Resource
    private ProductDictionaryMapper productDictionaryDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public ProductDictionary queryById(String uuid) {
        return this.productDictionaryDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductDictionary> queryAllByLimit(int offset, int limit) {
        return this.productDictionaryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productDictionary 实例对象
     * @return 实例对象
     */
    @Override
    public ProductDictionary insert(ProductDictionary productDictionary) {
        productDictionary.setUuid(UUID.randomUUID().toString().replace("-", ""));
        productDictionary.setModifyTime(new Date());
        productDictionary.setCreateTime(new Date());
        this.productDictionaryDao.insert(productDictionary);
        return productDictionary;
    }

    /**
     * 修改数据
     *
     * @param productDictionary 实例对象
     * @return 实例对象
     */
    @Override
    public ProductDictionary update(ProductDictionary productDictionary) {
        if(StringUtil.isEmpty(productDictionary.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        productDictionary.setModifyTime(new Date());
        this.productDictionaryDao.update(productDictionary);
        return this.queryById(productDictionary.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.productDictionaryDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param productDictionary 实例对象
     * @return 对象列表
     */
    @Override
    public Page<ProductDictionary> queryAll(ProductDictionary productDictionary) {
        if(productDictionary.getPageSize() != null && productDictionary.getPageNum() != null) {
            PageHelper.startPage(productDictionary.getPageNum(), productDictionary.getPageSize());
        }
        Page<ProductDictionary> pages =  this.productDictionaryDao.queryAll(productDictionary);
        return pages;
    }
}