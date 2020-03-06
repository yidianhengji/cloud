package com.cloud.controller;

import com.cloud.entity.SysAdmin;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.PageInfo;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.SysAdminService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "管理用户模块")
@RestController
@RequestMapping("/sysAdmin")
public class SysAdminController {
    private static Logger log = LoggerFactory.getLogger(SysAdminController.class);

    @Resource
    private SysAdminService sysAdminService;

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<SysAdmin> queryOne(@RequestBody SysAdmin sysAdmin) {
        log.info("查询单个,uuid={}", sysAdmin.getUuid());
        SysAdmin one = sysAdminService.queryById(sysAdmin.getUuid());
        return new Result<SysAdmin>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<SysAdmin> add(@RequestBody SysAdmin sysAdmin) {
        log.info("新增,sysAdmin={}", sysAdmin);
        SysAdmin one = sysAdminService.insert(sysAdmin);
        return new Result<SysAdmin>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<SysAdmin> update(@RequestBody SysAdmin sysAdmin) {
        log.info("修改,sysAdmin={}", sysAdmin);
        SysAdmin one = sysAdminService.update(sysAdmin);
        return new Result<SysAdmin>(BusinessStatus.SUCCESS, one);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<SysAdmin> queryAll(@RequestBody SysAdmin sysAdmin) {
        log.info("分页查询,sysAdmin={}", sysAdmin);
        Page<SysAdmin> one = sysAdminService.queryAll(sysAdmin);
        PageInfo<SysAdmin> pageinfo = new PageInfo<>(one);
        return new ResultPage<SysAdmin>(BusinessStatus.SUCCESS, pageinfo);
    }

}