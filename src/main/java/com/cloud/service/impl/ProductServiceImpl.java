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

/**
 * 商品表(TbProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(String uuid) {
        return this.productDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Product> queryAllByLimit(int offset, int limit) {
        return this.productDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insert(Product product) {
        product.setUuid(UUID.randomUUID().toString().replace("-", ""));
        product.setModifyTime(new Date());
        product.setCreateTime(new Date());
        this.productDao.insert(product);
        return product;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product update(Product product) {
        if(StringUtil.isEmpty(product.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        product.setModifyTime(new Date());
        this.productDao.update(product);
        return this.queryById(product.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.productDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param product 实例对象
     * @return 对象列表
     */
    @Override
    public Page<Product> queryAll(Product product) {
        if(product.getPageSize() != null && product.getPageNum() != null) {
            PageHelper.startPage(product.getPageNum(), product.getPageSize());
        }
        Page<Product> pages =  this.productDao.queryAll(product);
        return pages;
    }
}