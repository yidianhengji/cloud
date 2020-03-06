package com.cloud.service.impl;

import com.cloud.dao.ProductReviewMapper;
import com.cloud.entity.ProductReview;
import com.cloud.handler.BusinessException;
import com.cloud.service.ProductReviewService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 商品评论(TbProductReview)表服务实现类
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@Service
public class ProductReviewServiceImpl implements ProductReviewService {
    @Resource
    private ProductReviewMapper productReviewDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public ProductReview queryById(String uuid) {
        return this.productReviewDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductReview> queryAllByLimit(int offset, int limit) {
        return this.productReviewDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productReview 实例对象
     * @return 实例对象
     */
    @Override
    public ProductReview insert(ProductReview productReview) {
        productReview.setUuid(UUID.randomUUID().toString().replace("-", ""));
        productReview.setModifyTime(new Date());
        productReview.setCreateTime(new Date());
        this.productReviewDao.insert(productReview);
        return productReview;
    }

    /**
     * 修改数据
     *
     * @param productReview 实例对象
     * @return 实例对象
     */
    @Override
    public ProductReview update(ProductReview productReview) {
        if(StringUtil.isEmpty(productReview.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        productReview.setModifyTime(new Date());
        this.productReviewDao.update(productReview);
        return this.queryById(productReview.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.productReviewDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param productReview 实例对象
     * @return 对象列表
     */
    @Override
    public Page<ProductReview> queryAll(ProductReview productReview) {
        if(productReview.getPageSize() != null && productReview.getPageNum() != null) {
            PageHelper.startPage(productReview.getPageNum(), productReview.getPageSize());
        }
        Page<ProductReview> pages =  this.productReviewDao.queryAll(productReview);
        return pages;
    }
}