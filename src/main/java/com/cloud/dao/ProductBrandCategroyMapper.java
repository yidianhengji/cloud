package com.cloud.dao;

import com.cloud.entity.ProductBrandCategroy;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 品牌分类关联表(TbProductBrandCategroy)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@Repository
public interface ProductBrandCategroyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ProductBrandCategroy queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductBrandCategroy> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param productBrandCategroy 实例对象
     * @return 对象列表
     */
    Page<ProductBrandCategroy> queryAll(ProductBrandCategroy productBrandCategroy);

    /**
     * 新增数据
     *
     * @param productBrandCategroy 实例对象
     * @return 影响行数
     */
    int insert(ProductBrandCategroy productBrandCategroy);

    /**
     * 修改数据
     *
     * @param productBrandCategroy 实例对象
     * @return 影响行数
     */
    int update(ProductBrandCategroy productBrandCategroy);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}