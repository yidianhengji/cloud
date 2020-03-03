package com.cloud.dao;

import com.cloud.entity.Admin;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    int insert(Admin admin);

    int update(Admin admin);

    Page<Admin> query(Admin admin);
}
