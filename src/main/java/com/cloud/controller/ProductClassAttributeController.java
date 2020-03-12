package com.cloud.controller;

import com.cloud.entity.ProductClassAttribute;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.ProductClassAttributeService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/productClassAttribute")
@Api(tags = "商品类目属性表")
public class ProductClassAttributeController {
    private static Logger log = LoggerFactory.getLogger(ProductClassAttributeController.class);

    @Resource
    private ProductClassAttributeService productClassAttributeService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ProductClassAttribute> queryOne(@RequestBody ProductClassAttribute productClassAttribute) {
        log.info("查询单个,uuid={}", productClassAttribute.getUuid());
        ProductClassAttribute one = productClassAttributeService.queryById(productClassAttribute.getUuid());
        return new Result<ProductClassAttribute>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ProductClassAttribute> add(@RequestBody ProductClassAttribute productClassAttribute) {
        log.info("新增,productClassAttribute={}", productClassAttribute);
        ProductClassAttribute one = productClassAttributeService.insert(productClassAttribute);
        return new Result<ProductClassAttribute>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ProductClassAttribute> update(@RequestBody ProductClassAttribute productClassAttribute) {
        log.info("修改,productClassAttribute={}", productClassAttribute);
        ProductClassAttribute one = productClassAttributeService.update(productClassAttribute);
        return new Result<ProductClassAttribute>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<ProductClassAttribute> queryAll(@RequestBody ProductClassAttribute productClassAttribute) {
        log.info("分页查询,productClassAttribute={}", productClassAttribute);
        Page<ProductClassAttribute> one = productClassAttributeService.queryAll(productClassAttribute);
        PageInfo<ProductClassAttribute> pageinfo = new PageInfo<>(one);
        return new ResultPage<ProductClassAttribute>(BusinessStatus.SUCCESS, pageinfo);
    }

}