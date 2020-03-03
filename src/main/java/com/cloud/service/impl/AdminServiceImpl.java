package com.cloud.service.impl;

import com.cloud.dao.AdminMapper;
import com.cloud.entity.Admin;
import com.cloud.handler.CommonConst;
import com.cloud.service.AdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminDao;

    @Override
    public Page<Admin> query(Admin admin) {
        PageHelper.startPage(admin.getPageNum(), admin.getPageSize());
        Page<Admin> adminPage = adminDao.query(admin);
        return adminPage;
    }

    @Override
    public int update(Admin admin) {
        if(admin.getPassword()!= null) {
            String md5Password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
            admin.setPassword(md5Password);
        }
        admin.setModifyTime(new Date());
        return adminDao.update(admin);
    }

    @Override
    public int add(Admin admin) {
        String md5Password = DigestUtils.md5DigestAsHex(CommonConst.PASSWORD.getBytes());
        admin.setUuid(UUID.randomUUID().toString().replace("-", ""));
        admin.setPassword(md5Password);
        admin.setStatus(1);
        admin.setCreateTime(new Date());
        admin.setModifyTime(new Date());
        return adminDao.insert(admin);
    }

    @Override
    public Admin queryById(String uuid) {
        Admin admin = adminDao.queryById(uuid);
        return admin;
    }
}
