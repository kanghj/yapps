package com.vouov.yapps.model;

import java.util.Date;

public class UserPermission {
    private Integer userPermissionID;

    private Integer userID;

    private Integer permissionID;

    private Boolean grant;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public Integer getUserPermissionID() {
        return userPermissionID;
    }

    public void setUserPermissionID(Integer userPermissionID) {
        this.userPermissionID = userPermissionID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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