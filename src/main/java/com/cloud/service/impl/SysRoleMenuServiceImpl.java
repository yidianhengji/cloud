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

/**
 * 角色菜单资源表(TbSysRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 17:22:56
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public SysRoleMenu queryById(String uuid) {
        return this.sysRoleMenuDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRoleMenu> queryAllByLimit(int offset, int limit) {
        return this.sysRoleMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleMenu insert(SysRoleMenu sysRoleMenu) {
        sysRoleMenu.setUuid(UUID.randomUUID().toString().replace("-", ""));
        this.sysRoleMenuDao.insert(sysRoleMenu);
        return sysRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param sysRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleMenu update(SysRoleMenu sysRoleMenu) {
        if(StringUtil.isEmpty(sysRoleMenu.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        this.sysRoleMenuDao.update(sysRoleMenu);
        return this.queryById(sysRoleMenu.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.sysRoleMenuDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param sysRoleMenu 实例对象
     * @return 对象列表
     */
    @Override
    public Page<SysRoleMenu> queryAll(SysRoleMenu sysRoleMenu) {
        if(sysRoleMenu.getPageSize() != null && sysRoleMenu.getPageNum() != null) {
            PageHelper.startPage(sysRoleMenu.getPageNum(), sysRoleMenu.getPageSize());
        }
        Page<SysRoleMenu> pages =  this.sysRoleMenuDao.queryAll(sysRoleMenu);
        return pages;
    }
}