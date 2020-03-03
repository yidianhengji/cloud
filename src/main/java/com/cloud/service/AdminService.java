package com.cloud.service;

import com.cloud.entity.Admin;
import com.github.pagehelper.Page;

public interface AdminService {

    Page<Admin> query(Admin admin);

    int update(Admin admin);

    int add(Admin admin);

}
