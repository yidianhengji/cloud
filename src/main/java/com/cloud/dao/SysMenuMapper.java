package com.cloud.dao;

import com.cloud.entity.SysMenu;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SysMenuMapper {

    SysMenu queryById(@Param(value="uuid")String uuid);

    List<SysMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<SysMenu> queryAll(SysMenu sysMenu);

    int insert(SysMenu sysMenu);

    int update(SysMenu sysMenu);

    int deleteById(String uuid);

}