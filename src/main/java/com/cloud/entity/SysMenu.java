package com.cloud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class SysMenu implements Serializable {
    private static final long serialVersionUID = -98805086958558089L;
    //主键
    private String uuid;
    //名称
    private String name;
    //级别
    private Integer level;
    //图标
    private String icon;
    //路径
    private String url;
    //上级菜单
    private String menuUuid;
    //是否删除
    private Integer isDelete;
    //创建时间
    private Date createTime;
    //修改时间
    private Date modifyTime;

	private Integer pageSize;

	private Integer pageNum;

    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getMenuUuid() {
        return menuUuid;
    }

    public void setMenuUuid(String menuUuid) {
        this.menuUuid = menuUuid;
    }
    
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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