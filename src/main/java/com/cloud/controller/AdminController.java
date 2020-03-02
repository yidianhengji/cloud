package com.cloud.controller;

import com.cloud.entity.Admin;
import com.cloud.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Admin> query() {
        return adminService.query();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestBody Admin admin) {
        return adminService.add(admin);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }

}
