package com.cloud.dao;

import com.cloud.entity.SysRole;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper {

    SysRole queryById(@Param(value="uuid")String uuid);

    List<SysRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<SysRole> queryAll(SysRole sysRole);

    int insert(SysRole sysRole);

    int update(SysRole sysRole);

    int deleteById(String uuid);

}