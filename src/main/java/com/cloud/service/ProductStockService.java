package com.cloud.service;

import com.cloud.entity.ProductStock;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 商品库存(TbProductStock)表服务接口
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
public interface ProductStockService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ProductStock queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductStock> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param productStock 实例对象
     * @return 实例对象
     */
    ProductStock insert(ProductStock productStock);

    /**
     * 修改数据
     *
     * @param productStock 实例对象
     * @return 实例对象
     */
    ProductStock update(ProductStock productStock);

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
     * @param productStock 实例对象
     * @return 对象列表
     */
    Page<ProductStock> queryAll(ProductStock productStock);
}