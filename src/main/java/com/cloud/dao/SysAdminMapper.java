package com.cloud.dao;

import com.cloud.entity.SysAdmin;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysAdminMapper {

    SysAdmin queryById(@Param(value = "uuid") String uuid);

    List<SysAdmin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<SysAdmin> queryAll(SysAdmin sysAdmin);

    int insert(SysAdmin sysAdmin);

    int update(SysAdmin sysAdmin);

    int deleteById(String uuid);

}