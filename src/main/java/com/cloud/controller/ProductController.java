package com.cloud.controller;

import com.cloud.entity.Product;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.ProductService;
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
@RequestMapping("/product")
@Api(tags = "商品表")
public class ProductController {
    private static Logger log = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Product> queryOne(@RequestBody Product product) {
        log.info("查询单个,uuid={}", product.getUuid());
        Product one = productService.queryById(product.getUuid());
        return new Result<Product>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Product> add(@RequestBody Product product) {
        log.info("新增,product={}", product);
        Product one = productService.insert(product);
        return new Result<Product>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Product> update(@RequestBody Product product) {
        log.info("修改,product={}", product);
        Product one = productService.update(product);
        return new Result<Product>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<Product> queryAll(@RequestBody Product product) {
        log.info("分页查询,product={}", product);
        Page<Product> one = productService.queryAll(product);
        PageInfo<Product> pageinfo = new PageInfo<>(one);
        return new ResultPage<Product>(BusinessStatus.SUCCESS, pageinfo);
    }

}