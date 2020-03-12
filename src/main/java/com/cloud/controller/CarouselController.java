package com.cloud.controller;

import com.cloud.entity.Carousel;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.CarouselService;
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
@RequestMapping("/carousel")
@Api(tags = "轮播图表")
public class CarouselController {
    private static Logger log = LoggerFactory.getLogger(CarouselController.class);

    @Resource
    private CarouselService carouselService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Carousel> queryOne(@RequestBody Carousel carousel) {
        log.info("查询单个,uuid={}", carousel.getUuid());
        Carousel one = carouselService.queryById(carousel.getUuid());
        return new Result<Carousel>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Carousel> add(@RequestBody Carousel carousel) {
        log.info("新增,carousel={}", carousel);
        Carousel one = carouselService.insert(carousel);
        return new Result<Carousel>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Carousel> update(@RequestBody Carousel carousel) {
        log.info("修改,carousel={}", carousel);
        Carousel one = carouselService.update(carousel);
        return new Result<Carousel>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<Carousel> queryAll(@RequestBody Carousel carousel) {
        log.info("分页查询,carousel={}", carousel);
        Page<Carousel> one = carouselService.queryAll(carousel);
        PageInfo<Carousel> pageinfo = new PageInfo<>(one);
        return new ResultPage<Carousel>(BusinessStatus.SUCCESS, pageinfo);
    }

}