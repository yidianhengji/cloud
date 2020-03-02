package com.cloud.service.impl;

import com.cloud.dao.AdminDao;
import com.cloud.entity.Admin;
import com.cloud.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> query() {
        return adminDao.query();
    }

    @Override
    public int update(Admin admin) {
        return adminDao.update(admin);
    }

    @Override
    public int add(Admin admin) {
        admin.setUuid(UUID.randomUUID().toString().replace("-", ""));
        admin.setCreateTime(new Date());
        admin.setModifyTime(new Date());
        return adminDao.insert(admin);
    }
}
