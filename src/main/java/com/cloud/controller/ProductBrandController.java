package com.cloud.controller;

import com.cloud.entity.ProductBrand;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.ProductBrandService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Api(tags = "商品品牌模块")
@RestController
@RequestMapping("/productBrand")
public class ProductBrandController {
    private static Logger log = LoggerFactory.getLogger(ProductBrandController.class);

    @Resource
    private ProductBrandService productBrandService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ProductBrand> queryOne(@RequestBody ProductBrand productBrand) {
        log.info("查询单个,uuid={}", productBrand.getUuid());
        ProductBrand one = productBrandService.queryById(productBrand.getUuid());
        return new Result<ProductBrand>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ProductBrand> add(@RequestBody ProductBrand productBrand) {
        log.info("新增,productBrand={}", productBrand);
        ProductBrand one = productBrandService.insert(productBrand);
        return new Result<ProductBrand>(BusinessStatus.SUCCESS,one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ProductBrand> update(@RequestBody ProductBrand productBrand) {
        log.info("修改,productBrand={}", productBrand);
        ProductBrand one = productBrandService.update(productBrand);
        return new Result<ProductBrand>(BusinessStatus.SUCCESS,one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<ProductBrand> queryAll(@RequestBody ProductBrand productBrand) {
        log.info("分页查询,productBrand={}", productBrand);
        Page<ProductBrand> one = productBrandService.queryAll(productBrand);
        PageInfo<ProductBrand> pageinfo = new PageInfo<>(one);
        return new ResultPage<ProductBrand>(BusinessStatus.SUCCESS,pageinfo);
    }

}