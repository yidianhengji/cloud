package com.cloud.dao;

import com.cloud.entity.ProductReview;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 商品评论(TbProductReview)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@Repository
public interface ProductReviewMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ProductReview queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductReview> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param productReview 实例对象
     * @return 对象列表
     */
    Page<ProductReview> queryAll(ProductReview productReview);

    /**
     * 新增数据
     *
     * @param productReview 实例对象
     * @return 影响行数
     */
    int insert(ProductReview productReview);

    /**
     * 修改数据
     *
     * @param productReview 实例对象
     * @return 影响行数
     */
    int update(ProductReview productReview);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}