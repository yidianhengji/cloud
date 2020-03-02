package com.cloud.entity;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {

    private String uuid;

    private String name;

    private String phone;

    private String password;

    private String roleId;

    private String headPic;

    private Integer status;

    private Date createTime;

    private Date modifyTime;

    @Override
    public String toString() {
        return "Admin{" + "uuid='" + uuid + '\'' + ", name='" + name + '\'' + ", phone='" + phone + '\'' + ", password='" + password + '\'' + ", roleId='" + roleId + '\'' + ", headPic='" + headPic + '\'' + ", status=" + status + ", createTime=" + createTime + ", modifyTime=" + modifyTime + '}';
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
