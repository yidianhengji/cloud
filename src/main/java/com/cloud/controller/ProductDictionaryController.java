package com.cloud.controller;

import com.cloud.entity.ProductDictionary;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.ProductDictionaryService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品字典表(TbProductDictionary)表控制层
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
@RestController
@RequestMapping("/productDictionary")
public class ProductDictionaryController {
    private static Logger log = LoggerFactory.getLogger(ProductDictionaryController.class);

    /**
     * 服务对象
     */
    @Resource
    private ProductDictionaryService productDictionaryService;
    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ProductDictionary> queryOne(@RequestBody ProductDictionary productDictionary) {
        log.info("查询单个,uuid={}", productDictionary.getUuid());
        ProductDictionary one = productDictionaryService.queryById(productDictionary.getUuid());
        return new Result<ProductDictionary>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ProductDictionary> add(@RequestBody ProductDictionary productDictionary) {
        log.info("新增,productDictionary={}", productDictionary);
        ProductDictionary one = productDictionaryService.insert(productDictionary);
        return new Result<ProductDictionary>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ProductDictionary> update(@RequestBody ProductDictionary productDictionary) {
        log.info("修改,productDictionary={}", productDictionary);
        ProductDictionary one = productDictionaryService.update(productDictionary);
        return new Result<ProductDictionary>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<ProductDictionary> queryAll(@RequestBody ProductDictionary productDictionary) {
        log.info("分页查询,productDictionary={}", productDictionary);
        Page<ProductDictionary> one = productDictionaryService.queryAll(productDictionary);
        PageInfo<ProductDictionary> pageinfo = new PageInfo<>(one);
        return new ResultPage<ProductDictionary>(BusinessStatus.SUCCESS,pageinfo);
    }

}