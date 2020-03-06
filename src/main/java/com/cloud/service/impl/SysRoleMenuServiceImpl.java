package com.cloud.service.impl;

import com.cloud.dao.SysRoleMenuMapper;
import com.cloud.entity.SysRoleMenu;
import com.cloud.handler.BusinessException;
import com.cloud.service.SysRoleMenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuDao;

    @Override
    public SysRoleMenu queryById(String uuid) {
        return this.sysRoleMenuDao.queryById(uuid);
    }

    @Override
    public List<SysRoleMenu> queryAllByLimit(int offset, int limit) {
        return this.sysRoleMenuDao.queryAllByLimit(offset, limit);
    }

    @Override
    public SysRoleMenu insert(SysRoleMenu sysRoleMenu) {
        sysRoleMenu.setUuid(UUID.randomUUID().toString().replace("-", ""));
        this.sysRoleMenuDao.insert(sysRoleMenu);
        return sysRoleMenu;
    }

    @Override
    public SysRoleMenu update(SysRoleMenu sysRoleMenu) {
        if(StringUtil.isEmpty(sysRoleMenu.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        this.sysRoleMenuDao.update(sysRoleMenu);
        return this.queryById(sysRoleMenu.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.sysRoleMenuDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<SysRoleMenu> queryAll(SysRoleMenu sysRoleMenu) {
        if(sysRoleMenu.getPageSize() != null && sysRoleMenu.getPageNum() != null) {
            PageHelper.startPage(sysRoleMenu.getPageNum(), sysRoleMenu.getPageSize());
        }
        Page<SysRoleMenu> pages =  this.sysRoleMenuDao.queryAll(sysRoleMenu);
        return pages;
    }
}