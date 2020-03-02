package com.cloud.service;

import com.cloud.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> query();

    int update(Admin admin);

    int add(Admin admin);

}
