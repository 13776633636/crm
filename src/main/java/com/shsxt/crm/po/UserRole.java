package com.shsxt.crm.po;

import java.util.Date;

public class UserRole {
    private Integer id;
    private Integer userId;
    private String roleId;
    private Date createDate;
    private Date updateDate;

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", UserId=" + userId +
                ", RoleId=" + roleId +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
