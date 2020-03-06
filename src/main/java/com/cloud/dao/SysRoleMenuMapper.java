package com.cloud.dao;

import com.cloud.entity.SysRoleMenu;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SysRoleMenuMapper {

    SysRoleMenu queryById(@Param(value="uuid")String uuid);

    List<SysRoleMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<SysRoleMenu> queryAll(SysRoleMenu sysRoleMenu);

    int insert(SysRoleMenu sysRoleMenu);

    int update(SysRoleMenu sysRoleMenu);

    int deleteById(String uuid);

}