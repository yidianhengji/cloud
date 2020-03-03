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

/**
 * 菜单表(TbSysMenu)表控制层
 *
 * @author makejava
 * @since 2020-03-03 17:18:19
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    private static Logger log = LoggerFactory.getLogger(SysMenuController.class);

    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<SysMenu> queryOne(@RequestBody SysMenu sysMenu) {
        log.info("查询单个,uuid={}", sysMenu.getUuid());

        SysMenu one = sysMenuService.queryById(sysMenu.getUuid());
        return new Result<SysMenu>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<SysMenu> add(@RequestBody SysMenu sysMenu) {
        log.info("新增,sysMenu={}", sysMenu);

        SysMenu one = sysMenuService.insert(sysMenu);
        return new Result<SysMenu>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<SysMenu> update(@RequestBody SysMenu sysMenu) {
        log.info("修改,sysMenu={}", sysMenu);

        SysMenu one = sysMenuService.update(sysMenu);
        return new Result<SysMenu>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<SysMenu> queryAll(@RequestBody SysMenu sysMenu) {
        log.info("分页查询,sysMenu={}", sysMenu);

        Page<SysMenu> one = sysMenuService.queryAll(sysMenu);
        PageInfo<SysMenu> pageinfo = new PageInfo<>(one);
        return new ResultPage<SysMenu>(BusinessStatus.SUCCESS,pageinfo);
    }

}