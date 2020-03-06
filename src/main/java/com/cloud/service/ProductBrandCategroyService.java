package com.cloud.service;

import com.cloud.entity.ProductBrandCategroy;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 品牌分类关联表(TbProductBrandCategroy)表服务接口
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
public interface ProductBrandCategroyService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ProductBrandCategroy queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductBrandCategroy> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param productBrandCategroy 实例对象
     * @return 实例对象
     */
    ProductBrandCategroy insert(ProductBrandCategroy productBrandCategroy);

    /**
     * 修改数据
     *
     * @param productBrandCategroy 实例对象
     * @return 实例对象
     */
    ProductBrandCategroy update(ProductBrandCategroy productBrandCategroy);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    boolean deleteById(String uuid);

     /**
     * 通过实体作为筛选条件查询
     *
     * @param productBrandCategroy 实例对象
     * @return 对象列表
     */
    Page<ProductBrandCategroy> queryAll(ProductBrandCategroy productBrandCategroy);
}