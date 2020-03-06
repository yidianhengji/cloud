package com.cloud.service.impl;

import com.cloud.dao.ProductStockMapper;
import com.cloud.entity.ProductStock;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductStockService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 商品库存(TbProductStock)表服务实现类
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@Service
public class ProductStockServiceImpl implements ProductStockService {
    @Resource
    private ProductStockMapper productStockDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public ProductStock queryById(String uuid) {
        return this.productStockDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductStock> queryAllByLimit(int offset, int limit) {
        return this.productStockDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productStock 实例对象
     * @return 实例对象
     */
    @Override
    public ProductStock insert(ProductStock productStock) {
        productStock.setUuid(UUID.randomUUID().toString().replace("-", ""));
        productStock.setModifyTime(new Date());
        productStock.setCreateTime(new Date());
        this.productStockDao.insert(productStock);
        return productStock;
    }

    /**
     * 修改数据
     *
     * @param productStock 实例对象
     * @return 实例对象
     */
    @Override
    public ProductStock update(ProductStock productStock) {
        if(StringUtil.isEmpty(productStock.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        productStock.setModifyTime(new Date());
        this.productStockDao.update(productStock);
        return this.queryById(productStock.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.productStockDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param productStock 实例对象
     * @return 对象列表
     */
    @Override
    public Page<ProductStock> queryAll(ProductStock productStock) {
        if(productStock.getPageSize() != null && productStock.getPageNum() != null) {
            PageHelper.startPage(productStock.getPageNum(), productStock.getPageSize());
        }
        Page<ProductStock> pages =  this.productStockDao.queryAll(productStock);
        return pages;
    }
}