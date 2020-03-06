package com.cloud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = -17312522749890561L;
    //主键
    private String uuid;
    //角色id
    private String roleId;
    //菜单id
    private String menuId;

	private Integer pageSize;

	private Integer pageNum;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @JsonIgnore
	public Integer getPageSize() {
		return pageSize;
	}

    @JsonIgnore
	public Integer getPageNum() {
		return pageNum;
	}

    @JsonProperty
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

    @JsonProperty
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}