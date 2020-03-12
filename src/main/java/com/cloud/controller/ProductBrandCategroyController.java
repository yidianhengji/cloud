package com.cloud.controller;

import com.cloud.entity.ProductBrandCategroy;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.Result;
import com.cloud.service.ProductBrandCategroyService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/productBrandCategroy")
@Api(tags = "品牌分类关联表")
public class ProductBrandCategroyController {
    private static Logger log = LoggerFactory.getLogger(ProductBrandCategroyController.class);

    @Resource
    private ProductBrandCategroyService productBrandCategroyService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ProductBrandCategroy> queryOne(@RequestBody ProductBrandCategroy productBrandCategroy) {
        log.info("查询单个,uuid={}", productBrandCategroy.getUuid());
        ProductBrandCategroy one = productBrandCategroyService.queryById(productBrandCategroy.getUuid());
        return new Result<ProductBrandCategroy>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ProductBrandCategroy> add(@RequestBody ProductBrandCategroy productBrandCategroy) {
        log.info("新增,productBrandCategroy={}", productBrandCategroy);
        ProductBrandCategroy one = productBrandCategroyService.insert(productBrandCategroy);
        return new Result<ProductBrandCategroy>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ProductBrandCategroy> update(@RequestBody ProductBrandCategroy productBrandCategroy) {
        log.info("修改,productBrandCategroy={}", productBrandCategroy);
        ProductBrandCategroy one = productBrandCategroyService.update(productBrandCategroy);
        return new Result<ProductBrandCategroy>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public Result<List<ProductBrandCategroy>> queryAll(@RequestBody ProductBrandCategroy productBrandCategroy) {
        log.info("分页查询,productBrandCategroy={}", productBrandCategroy);
        List<ProductBrandCategroy> list = productBrandCategroyService.queryAll(productBrandCategroy);
        return new Result<List<ProductBrandCategroy>>(BusinessStatus.SUCCESS, list);
    }

}