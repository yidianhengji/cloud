package com.cloud.controller;

import com.cloud.entity.ProductReview;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.ProductReviewService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品评论(TbProductReview)表控制层
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@RestController
@RequestMapping("/productReview")
public class ProductReviewController {
    private static Logger log = LoggerFactory.getLogger(ProductReviewController.class);

    /**
     * 服务对象
     */
    @Resource
    private ProductReviewService productReviewService;
    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ProductReview> queryOne(@RequestBody ProductReview productReview) {
        log.info("查询单个,uuid={}", productReview.getUuid());
        ProductReview one = productReviewService.queryById(productReview.getUuid());
        return new Result<ProductReview>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ProductReview> add(@RequestBody ProductReview productReview) {
        log.info("新增,productReview={}", productReview);
        ProductReview one = productReviewService.insert(productReview);
        return new Result<ProductReview>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ProductReview> update(@RequestBody ProductReview productReview) {
        log.info("修改,productReview={}", productReview);
        ProductReview one = productReviewService.update(productReview);
        return new Result<ProductReview>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<ProductReview> queryAll(@RequestBody ProductReview productReview) {
        log.info("分页查询,productReview={}", productReview);
        Page<ProductReview> one = productReviewService.queryAll(productReview);
        PageInfo<ProductReview> pageinfo = new PageInfo<>(one);
        return new ResultPage<ProductReview>(BusinessStatus.SUCCESS,pageinfo);
    }

}