package com.cloud.controller;

import com.cloud.entity.SysRole;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.SysRoleService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    private static Logger log = LoggerFactory.getLogger(SysRoleController.class);

    @Resource
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<SysRole> queryOne(@RequestBody SysRole sysRole) {
        log.info("查询单个,uuid={}", sysRole.getUuid());
        SysRole one = sysRoleService.queryById(sysRole.getUuid());
        return new Result<SysRole>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<SysRole> add(@RequestBody SysRole sysRole) {
        log.info("新增,sysRole={}", sysRole);
        SysRole one = sysRoleService.insert(sysRole);
        return new Result<SysRole>(BusinessStatus.SUCCESS,one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<SysRole> update(@RequestBody SysRole sysRole) {
        log.info("修改,sysRole={}", sysRole);
        SysRole one = sysRoleService.update(sysRole);
        return new Result<SysRole>(BusinessStatus.SUCCESS,one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<SysRole> queryAll(@RequestBody SysRole sysRole) {
        log.info("分页查询,sysRole={}", sysRole);
        Page<SysRole> one = sysRoleService.queryAll(sysRole);
        PageInfo<SysRole> pageinfo = new PageInfo<>(one);
        return new ResultPage<SysRole>(BusinessStatus.SUCCESS,pageinfo);
    }

}