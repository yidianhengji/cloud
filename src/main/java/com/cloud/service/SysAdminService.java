package com.cloud.service;

import com.cloud.entity.SysAdmin;
import com.github.pagehelper.Page;

import java.util.List;

public interface SysAdminService {

    SysAdmin queryById(String uuid);

    List<SysAdmin> queryAllByLimit(int offset, int limit);

    SysAdmin insert(SysAdmin sysAdmin);

    SysAdmin update(SysAdmin sysAdmin);

    boolean deleteById(String uuid);

    Page<SysAdmin> queryAll(SysAdmin sysAdmin);
}