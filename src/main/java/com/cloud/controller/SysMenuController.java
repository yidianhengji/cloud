package com.cloud.controller;

import com.cloud.entity.SysMenu;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.SysMenuService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    private static Logger log = LoggerFactory.getLogger(SysMenuController.class);

    @Resource
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<SysMenu> queryOne(@RequestBody SysMenu sysMenu) {
        log.info("查询单个,uuid={}", sysMenu.getUuid());
        SysMenu one = sysMenuService.queryById(sysMenu.getUuid());
        return new Result<SysMenu>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<SysMenu> add(@RequestBody SysMenu sysMenu) {
        log.info("新增,sysMenu={}", sysMenu);
        SysMenu one = sysMenuService.insert(sysMenu);
        return new Result<SysMenu>(BusinessStatus.SUCCESS,one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<SysMenu> update(@RequestBody SysMenu sysMenu) {
        log.info("修改,sysMenu={}", sysMenu);
        SysMenu one = sysMenuService.update(sysMenu);
        return new Result<SysMenu>(BusinessStatus.SUCCESS,one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<SysMenu> queryAll(@RequestBody SysMenu sysMenu) {
        log.info("分页查询,sysMenu={}", sysMenu);
        Page<SysMenu> one = sysMenuService.queryAll(sysMenu);
        PageInfo<SysMenu> pageinfo = new PageInfo<>(one);
        return new ResultPage<SysMenu>(BusinessStatus.SUCCESS,pageinfo);
    }

}