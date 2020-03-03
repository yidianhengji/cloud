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

/**
 * 菜单表(TbSysMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 17:18:19
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public SysMenu queryById(String uuid) {
        return this.sysMenuDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysMenu> queryAllByLimit(int offset, int limit) {
        return this.sysMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu insert(SysMenu sysMenu) {
        sysMenu.setUuid(UUID.randomUUID().toString().replace("-", ""));
        sysMenu.setModifyTime(new Date());
        sysMenu.setCreateTime(new Date());
        this.sysMenuDao.insert(sysMenu);
        return sysMenu;
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu update(SysMenu sysMenu) {
        if(StringUtil.isEmpty(sysMenu.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        sysMenu.setModifyTime(new Date());
        this.sysMenuDao.update(sysMenu);
        return this.queryById(sysMenu.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.sysMenuDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param sysMenu 实例对象
     * @return 对象列表
     */
    @Override
    public Page<SysMenu> queryAll(SysMenu sysMenu) {
        if(sysMenu.getPageSize() != null && sysMenu.getPageNum() != null) {
            PageHelper.startPage(sysMenu.getPageNum(), sysMenu.getPageSize());
        }
        Page<SysMenu> pages =  this.sysMenuDao.queryAll(sysMenu);
        return pages;
    }
}