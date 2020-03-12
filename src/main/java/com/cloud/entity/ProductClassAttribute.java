package com.cloud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "商品类目属性表")
public class ProductClassAttribute implements Serializable {

    private static final long serialVersionUID = 544917567573461383L;

    @ApiModelProperty(value = "主键")
    private String uuid;

    @ApiModelProperty(value = "编码code")
    private String code;

    @ApiModelProperty(value = "键")
    private String name;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "值")
    private String value;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "是否必填")
    private Integer required;

    @ApiModelProperty(value = "1、输入框  2、时间  3、选择框")
    private Integer type;

    @ApiModelProperty(value = "对应的字典表code")
    private String typeCode;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
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