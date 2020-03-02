package com.cloud.dao;

import com.cloud.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {

    int insert(Admin admin);

    int update(Admin admin);

    List<Admin> query();
}
