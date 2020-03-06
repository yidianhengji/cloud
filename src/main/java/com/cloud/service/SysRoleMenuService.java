package com.cloud.service;

import com.cloud.entity.SysRoleMenu;
import com.github.pagehelper.Page;
import java.util.List;

public interface SysRoleMenuService {

    SysRoleMenu queryById(String uuid);

    List<SysRoleMenu> queryAllByLimit(int offset, int limit);

    SysRoleMenu insert(SysRoleMenu sysRoleMenu);

    SysRoleMenu update(SysRoleMenu sysRoleMenu);

    boolean deleteById(String uuid);

    Page<SysRoleMenu> queryAll(SysRoleMenu sysRoleMenu);
}