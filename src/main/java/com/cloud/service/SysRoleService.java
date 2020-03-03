package com.cloud.service;

import com.cloud.entity.SysRole;
import com.github.pagehelper.Page;

import java.util.List;

public interface SysRoleService {

    SysRole queryById(String uuid);

    List<SysRole> queryAllByLimit(int offset, int limit);

    SysRole insert(SysRole sysRole);

    SysRole update(SysRole sysRole);

    boolean deleteById(String uuid);

    Page<SysRole> queryAll(SysRole sysRole);
}