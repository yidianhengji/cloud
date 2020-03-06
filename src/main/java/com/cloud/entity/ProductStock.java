package com.cloud.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品库存(TbProductStock)实体类
 *
 * @author makejava
 * @since 2020-03-06 17:13:31
 */
public class ProductStock implements Serializable {
    private static final long serialVersionUID = 223014082884634245L;
    //主键
    private String uuid;
    //组合商品id
    private String combinationId;
    //商品_id
    private String productId;
    //修改时间
    private Date modifyTime;
    //添加时间
    private Date createTime;

	private Integer pageSize;

	private Integer pageNum;

    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(String combinationId) {
        this.combinationId = combinationId;
    }
    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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