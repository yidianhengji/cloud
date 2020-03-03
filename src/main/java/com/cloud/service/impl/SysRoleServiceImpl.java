package com.cloud.service.impl;

import com.cloud.dao.SysRoleMapper;
import com.cloud.entity.SysRole;
import com.cloud.handler.BusinessException;
import com.cloud.service.SysRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleDao;

    @Override
    public SysRole queryById(String uuid) {
        return this.sysRoleDao.queryById(uuid);
    }

    @Override
    public List<SysRole> queryAllByLimit(int offset, int limit) {
        return this.sysRoleDao.queryAllByLimit(offset, limit);
    }

    @Override
    public SysRole insert(SysRole sysRole) {
        sysRole.setUuid(UUID.randomUUID().toString().replace("-", ""));
        sysRole.setCreateTime(new Date());
        this.sysRoleDao.insert(sysRole);
        return sysRole;
    }

    @Override
    public SysRole update(SysRole sysRole) {
        if(StringUtil.isEmpty(sysRole.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        sysRole.setModifyTime(new Date());
        this.sysRoleDao.update(sysRole);
        return this.queryById(sysRole.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.sysRoleDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<SysRole> queryAll(SysRole sysRole) {
        if(sysRole.getPageSize() != null && sysRole.getPageNum() != null) {
            PageHelper.startPage(sysRole.getPageNum(), sysRole.getPageSize());
        }
        Page<SysRole> pages =  this.sysRoleDao.queryAll(sysRole);
        return pages;
    }
}