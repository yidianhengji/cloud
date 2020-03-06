package com.cloud.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

public class ProductCategory implements Serializable {
    private static final long serialVersionUID = -70960669553753633L;
    //主键
    private String uuid;
    //上级id
    private String categoryId;
    //级别
    private Integer level;
    //名称
    private String name;
    //分类CODE
    private String categoryCode;
    //是否删除 是否删除 是否删除 是否删除 1、是 2、否
    private Integer isDelete;
    //类目属性code
    private String clasAttribute;
    //销售信息code 多的已逗号隔开
    private String salesInformation;
    //修改时间
    private Date modifyTime;
    //添加时间
    private Date createTime;

    private Integer pageSize;

    private Integer pageNum;

    private List<ProductCategory> childs;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<ProductCategory> getChilds() {
        return childs;
    }

    public void setChilds(List<ProductCategory> childs) {
        this.childs = childs;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getClasAttribute() {
        return clasAttribute;
    }

    public void setClasAttribute(String clasAttribute) {
        this.clasAttribute = clasAttribute;
    }

    public String getSalesInformation() {
        return salesInformation;
    }

    public void setSalesInformation(String salesInformation) {
        this.salesInformation = salesInformation;
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