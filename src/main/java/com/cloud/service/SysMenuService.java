package com.cloud.service;

import com.cloud.entity.SysMenu;
import com.github.pagehelper.Page;
import java.util.List;

public interface SysMenuService {

    SysMenu queryById(String uuid);

    List<SysMenu> queryAllByLimit(int offset, int limit);

    SysMenu insert(SysMenu sysMenu);

    SysMenu update(SysMenu sysMenu);

    boolean deleteById(String uuid);

    Page<SysMenu> queryAll(SysMenu sysMenu);
}