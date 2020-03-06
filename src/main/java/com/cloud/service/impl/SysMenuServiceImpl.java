package com.cloud.service.impl;

import com.cloud.dao.SysMenuMapper;
import com.cloud.entity.SysMenu;
import com.cloud.handler.BusinessException;
import com.cloud.service.SysMenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuDao;

    @Override
    public SysMenu queryById(String uuid) {
        return this.sysMenuDao.queryById(uuid);
    }

    @Override
    public List<SysMenu> queryAllByLimit(int offset, int limit) {
        return this.sysMenuDao.queryAllByLimit(offset, limit);
    }

    @Override
    public SysMenu insert(SysMenu sysMenu) {
        sysMenu.setUuid(UUID.randomUUID().toString().replace("-", ""));
        sysMenu.setModifyTime(new Date());
        sysMenu.setCreateTime(new Date());
        this.sysMenuDao.insert(sysMenu);
        return sysMenu;
    }

    @Override
    public SysMenu update(SysMenu sysMenu) {
        if(StringUtil.isEmpty(sysMenu.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        sysMenu.setModifyTime(new Date());
        this.sysMenuDao.update(sysMenu);
        return this.queryById(sysMenu.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.sysMenuDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<SysMenu> queryAll(SysMenu sysMenu) {
        if(sysMenu.getPageSize() != null && sysMenu.getPageNum() != null) {
            PageHelper.startPage(sysMenu.getPageNum(), sysMenu.getPageSize());
        }
        Page<SysMenu> pages =  this.sysMenuDao.queryAll(sysMenu);
        return pages;
    }
}