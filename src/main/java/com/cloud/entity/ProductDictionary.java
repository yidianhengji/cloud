package com.cloud.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品字典表(TbProductDictionary)实体类
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
public class ProductDictionary implements Serializable {
    private static final long serialVersionUID = 542591355993828832L;
    //主键
    private String uuid;
    //编码code
    private String code;
    //键
    private String name;
    //值
    private String values;
    //级别
    private Integer level;
    //修改时间
    private Date modifyTime;
    //创建时间
    private Date createTime;

	private Integer pageSize;

	private Integer pageNum;

    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}