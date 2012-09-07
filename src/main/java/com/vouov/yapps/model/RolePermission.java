package com.vouov.yapps.model;

import java.util.Date;

public class RolePermission {
    private Integer rolePermissionID;

    private Integer roleID;

    private Integer permissionID;

    private Boolean grant;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public Integer getRolePermissionID() {
        return rolePermissionID;
    }

    public void setRolePermissionID(Integer rolePermissionID) {
        this.rolePermissionID = rolePermissionID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }

    public Boolean getGrant() {
        return grant;
    }

    public void setGrant(Boolean grant) {
        this.grant = grant;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}