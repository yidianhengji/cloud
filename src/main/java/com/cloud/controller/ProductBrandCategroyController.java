package com.cloud.controller;

import com.cloud.entity.ProductBrandCategroy;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.ProductBrandCategroyService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 品牌分类关联表(TbProductBrandCategroy)表控制层
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@RestController
@RequestMapping("/productBrandCategroy")
public class ProductBrandCategroyController {
    private static Logger log = LoggerFactory.getLogger(ProductBrandCategroyController.class);

    /**
     * 服务对象
     */
    @Resource
    private ProductBrandCategroyService productBrandCategroyService;
    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ProductBrandCategroy> queryOne(@RequestBody ProductBrandCategroy productBrandCategroy) {
        log.info("查询单个,uuid={}", productBrandCategroy.getUuid());
        ProductBrandCategroy one = productBrandCategroyService.queryById(productBrandCategroy.getUuid());
        return new Result<ProductBrandCategroy>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ProductBrandCategroy> add(@RequestBody ProductBrandCategroy productBrandCategroy) {
        log.info("新增,productBrandCategroy={}", productBrandCategroy);
        ProductBrandCategroy one = productBrandCategroyService.insert(productBrandCategroy);
        return new Result<ProductBrandCategroy>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ProductBrandCategroy> update(@RequestBody ProductBrandCategroy productBrandCategroy) {
        log.info("修改,productBrandCategroy={}", productBrandCategroy);
        ProductBrandCategroy one = productBrandCategroyService.update(productBrandCategroy);
        return new Result<ProductBrandCategroy>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<ProductBrandCategroy> queryAll(@RequestBody ProductBrandCategroy productBrandCategroy) {
        log.info("分页查询,productBrandCategroy={}", productBrandCategroy);
        Page<ProductBrandCategroy> one = productBrandCategroyService.queryAll(productBrandCategroy);
        PageInfo<ProductBrandCategroy> pageinfo = new PageInfo<>(one);
        return new ResultPage<ProductBrandCategroy>(BusinessStatus.SUCCESS,pageinfo);
    }

}