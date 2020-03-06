package com.cloud.service.impl;

import com.cloud.dao.ProductBrandCategroyMapper;
import com.cloud.entity.ProductBrandCategroy;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductBrandCategroyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 品牌分类关联表(TbProductBrandCategroy)表服务实现类
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@Service
public class ProductBrandCategroyServiceImpl implements ProductBrandCategroyService {
    @Resource
    private ProductBrandCategroyMapper productBrandCategroyDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */


    @Override
    public ProductBrandCategroy queryById(String uuid) {
        return this.productBrandCategroyDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductBrandCategroy> queryAllByLimit(int offset, int limit) {
        return this.productBrandCategroyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productBrandCategroy 实例对象
     * @return 实例对象
     */
    @Override
    public ProductBrandCategroy insert(ProductBrandCategroy productBrandCategroy) {
        productBrandCategroy.setUuid(UUID.randomUUID().toString().replace("-", ""));
        this.productBrandCategroyDao.insert(productBrandCategroy);
        return productBrandCategroy;
    }

    /**
     * 修改数据
     *
     * @param productBrandCategroy 实例对象
     * @return 实例对象
     */
    @Override
    public ProductBrandCategroy update(ProductBrandCategroy productBrandCategroy) {
        if(StringUtil.isEmpty(productBrandCategroy.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        this.productBrandCategroyDao.update(productBrandCategroy);
        return this.queryById(productBrandCategroy.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.productBrandCategroyDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param productBrandCategroy 实例对象
     * @return 对象列表
     */
    @Override
    public Page<ProductBrandCategroy> queryAll(ProductBrandCategroy productBrandCategroy) {
        if(productBrandCategroy.getPageSize() != null && productBrandCategroy.getPageNum() != null) {
            PageHelper.startPage(productBrandCategroy.getPageNum(), productBrandCategroy.getPageSize());
        }
        Page<ProductBrandCategroy> pages =  this.productBrandCategroyDao.queryAll(productBrandCategroy);
        return pages;
    }
}