package com.cloud.entity;

import java.io.Serializable;

/**
 * 品牌分类关联表(TbProductBrandCategroy)实体类
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
public class ProductBrandCategroy implements Serializable {
    private static final long serialVersionUID = -66141474127739160L;
    //主键
    private String uuid;
    //品牌id
    private String brandId;
    //分类id
    private String categoryId;

	private Integer pageSize;

	private Integer pageNum;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
    
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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