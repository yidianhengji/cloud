package com.cloud.service.impl;

import com.cloud.dao.SysAdminMapper;
import com.cloud.entity.SysAdmin;
import com.cloud.handler.BusinessException;
import com.cloud.handler.CommonConst;
import com.cloud.service.SysAdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class SysAdminServiceImpl implements SysAdminService {
    @Resource
    private SysAdminMapper sysAdminDao;

    @Override
    public SysAdmin queryById(String uuid) {
        return this.sysAdminDao.queryById(uuid);
    }

    @Override
    public List<SysAdmin> queryAllByLimit(int offset, int limit) {
        return this.sysAdminDao.queryAllByLimit(offset, limit);
    }

    @Override
    public SysAdmin insert(SysAdmin sysAdmin) {
        String md5Password = DigestUtils.md5DigestAsHex(CommonConst.PASSWORD.getBytes());
        sysAdmin.setUuid(UUID.randomUUID().toString().replace("-", ""));
        sysAdmin.setModifyTime(new Date());
        sysAdmin.setCreateTime(new Date());
        sysAdmin.setPassword(md5Password);
        this.sysAdminDao.insert(sysAdmin);
        return sysAdmin;
    }

    @Override
    public SysAdmin update(SysAdmin sysAdmin) {
        if (StringUtil.isEmpty(sysAdmin.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        if (sysAdmin.getPassword() != null) {
            String md5Password = DigestUtils.md5DigestAsHex(sysAdmin.getPassword().getBytes());
            sysAdmin.setPassword(md5Password);
        }
        sysAdmin.setModifyTime(new Date());
        this.sysAdminDao.update(sysAdmin);
        return this.queryById(sysAdmin.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.sysAdminDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<SysAdmin> queryAll(SysAdmin sysAdmin) {
        if (sysAdmin.getPageSize() != null && sysAdmin.getPageNum() != null) {
            PageHelper.startPage(sysAdmin.getPageNum(), sysAdmin.getPageSize());
        }
        Page<SysAdmin> pages = this.sysAdminDao.queryAll(sysAdmin);
        return pages;
    }
}