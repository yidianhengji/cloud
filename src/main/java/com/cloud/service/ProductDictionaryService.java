package com.cloud.service;

import com.cloud.entity.ProductDictionary;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 商品字典表(TbProductDictionary)表服务接口
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
public interface ProductDictionaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ProductDictionary queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductDictionary> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param productDictionary 实例对象
     * @return 实例对象
     */
    ProductDictionary insert(ProductDictionary productDictionary);

    /**
     * 修改数据
     *
     * @param productDictionary 实例对象
     * @return 实例对象
     */
    ProductDictionary update(ProductDictionary productDictionary);

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
     * @param productDictionary 实例对象
     * @return 对象列表
     */
    Page<ProductDictionary> queryAll(ProductDictionary productDictionary);
}