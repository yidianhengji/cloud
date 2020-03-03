package com.cloud.controller;

import com.cloud.entity.SysRoleMenu;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.SysRoleMenuService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色菜单资源表(TbSysRoleMenu)表控制层
 *
 * @author makejava
 * @since 2020-03-03 17:22:56
 */
@RestController
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController {
    private static Logger log = LoggerFactory.getLogger(SysRoleMenuController.class);

    /**
     * 服务对象
     */
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<SysRoleMenu> queryOne(@RequestBody SysRoleMenu sysRoleMenu) {
        log.info("查询单个,uuid={}", sysRoleMenu.getUuid());

        SysRoleMenu one = sysRoleMenuService.queryById(sysRoleMenu.getUuid());
        return new Result<SysRoleMenu>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<SysRoleMenu> add(@RequestBody SysRoleMenu sysRoleMenu) {
        log.info("新增,sysRoleMenu={}", sysRoleMenu);

        SysRoleMenu one = sysRoleMenuService.insert(sysRoleMenu);
        return new Result<SysRoleMenu>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<SysRoleMenu> update(@RequestBody SysRoleMenu sysRoleMenu) {
        log.info("修改,sysRoleMenu={}", sysRoleMenu);

        SysRoleMenu one = sysRoleMenuService.update(sysRoleMenu);
        return new Result<SysRoleMenu>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<SysRoleMenu> queryAll(@RequestBody SysRoleMenu sysRoleMenu) {
        log.info("分页查询,sysRoleMenu={}", sysRoleMenu);

        Page<SysRoleMenu> one = sysRoleMenuService.queryAll(sysRoleMenu);
        PageInfo<SysRoleMenu> pageinfo = new PageInfo<>(one);
        return new ResultPage<SysRoleMenu>(BusinessStatus.SUCCESS,pageinfo);
    }

}