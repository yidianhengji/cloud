package com.cloud.controller;

import com.cloud.entity.ProductStock;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.ProductStockService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品库存(TbProductStock)表控制层
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@RestController
@RequestMapping("/productStock")
public class ProductStockController {
    private static Logger log = LoggerFactory.getLogger(ProductStockController.class);

    /**
     * 服务对象
     */
    @Resource
    private ProductStockService productStockService;
    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ProductStock> queryOne(@RequestBody ProductStock productStock) {
        log.info("查询单个,uuid={}", productStock.getUuid());
        ProductStock one = productStockService.queryById(productStock.getUuid());
        return new Result<ProductStock>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ProductStock> add(@RequestBody ProductStock productStock) {
        log.info("新增,productStock={}", productStock);
        ProductStock one = productStockService.insert(productStock);
        return new Result<ProductStock>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ProductStock> update(@RequestBody ProductStock productStock) {
        log.info("修改,productStock={}", productStock);
        ProductStock one = productStockService.update(productStock);
        return new Result<ProductStock>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<ProductStock> queryAll(@RequestBody ProductStock productStock) {
        log.info("分页查询,productStock={}", productStock);
        Page<ProductStock> one = productStockService.queryAll(productStock);
        PageInfo<ProductStock> pageinfo = new PageInfo<>(one);
        return new ResultPage<ProductStock>(BusinessStatus.SUCCESS,pageinfo);
    }

}