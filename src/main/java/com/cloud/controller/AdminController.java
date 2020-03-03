package com.cloud.controller;

import com.cloud.entity.Admin;
import com.cloud.handler.BusinessException;
import com.cloud.handler.BusinessStatus;
import com.cloud.handler.Result;
import com.cloud.handler.ResultPage;
import com.cloud.service.AdminService;
import com.github.pagehelper.Page;
import com.cloud.handler.PageInfo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
@Api(tags = "Admin模块")
public class AdminController {
    private static Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<Admin> query(@RequestBody @Valid Admin admin) {
        log.info("Admin分页条件查询，参数admin={}", admin);
        Page<Admin> adminPage = adminService.query(admin);
        PageInfo<Admin> pageInfo = new PageInfo<>(adminPage);
        return new ResultPage<Admin>(BusinessStatus.SUCCESS, pageInfo);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody @Valid Admin admin) {
        log.info("Admin新增，参数admin={}", admin);
        adminService.add(admin);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody @Valid Admin admin) {
        log.info("Admin修改，参数admin={}", admin);
        if (admin.getUuid() == null) {
            throw new BusinessException(BusinessStatus.UUID_REQ);
        }
        adminService.update(admin);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    public Result<Object> queryById(@RequestBody @Valid String uuid) {
        log.info("Admin查询单个，参数uuid={}", uuid);
        if (uuid==null) {
            throw new BusinessException(BusinessStatus.UUID_REQ);
        }
        Admin admin = adminService.queryById(uuid);
        return new Result<>(BusinessStatus.SUCCESS, admin);
    }

}
