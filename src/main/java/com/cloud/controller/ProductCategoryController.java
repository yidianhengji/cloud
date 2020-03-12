package com.cloud.controller;

import com.cloud.entity.ProductCategory;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.ProductCategoryService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品分类模块")
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    private static Logger log = LoggerFactory.getLogger(ProductCategoryController.class);

    @Resource
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ProductCategory> queryOne(@RequestBody ProductCategory productCategory) {
        log.info("查询单个,uuid={}", productCategory.getUuid());
        ProductCategory one = productCategoryService.queryById(productCategory.getUuid());
        return new Result<ProductCategory>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ProductCategory> add(@RequestBody ProductCategory productCategory) {
        log.info("新增,productCategory={}", productCategory);
        ProductCategory one = productCategoryService.insert(productCategory);
        return new Result<ProductCategory>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ProductCategory> update(@RequestBody ProductCategory productCategory) {
        log.info("修改,productCategory={}", productCategory);
        ProductCategory one = productCategoryService.update(productCategory);
        return new Result<ProductCategory>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<ProductCategory> queryAll(@RequestBody ProductCategory productCategory) {
        log.info("分页查询,productCategory={}", productCategory);
        Page<ProductCategory> one = productCategoryService.queryAll(productCategory);
        PageInfo<ProductCategory> pageinfo = new PageInfo<>(one);
        return new ResultPage<ProductCategory>(BusinessStatus.SUCCESS, pageinfo);
    }

    @RequestMapping(value = "/queryTree", method = RequestMethod.POST)
    public Result<List<ProductCategory>> queryTree(@RequestBody ProductCategory productCategory) {
        log.info("查询树形结构,productCategory={}", productCategory);
        List<ProductCategory> list = productCategoryService.queryTree(productCategory);
        return new Result<List<ProductCategory>>(BusinessStatus.SUCCESS, list);
    }

    @RequestMapping(value = "/queryFindCategoryId", method = RequestMethod.POST)
    public Result<List<ProductCategory>> queryFindCategoryId(@RequestBody ProductCategory productCategory) {
        log.info("查询树形结构,productCategory={}", productCategory.getCategoryId());
        List<ProductCategory> list = productCategoryService.queryFindCategoryId(productCategory.getCategoryId());
        return new Result<List<ProductCategory>>(BusinessStatus.SUCCESS, list);
    }

}