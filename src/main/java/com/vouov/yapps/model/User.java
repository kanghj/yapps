package com.vouov.yapps.model;

import com.vouov.yapps.json.serializer.DateTimeSerializer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

public class User {
    private Integer userID;

    private String loginName;

    @JsonIgnore
    private String password;

    private String userName;

    private String mobile;

    private String email;

    @JsonSerialize(using = DateTimeSerializer.class)
    private Date lastLoginTime;

    private Integer failLoginCount;

    private Boolean status;
    @JsonSerialize(using = DateTimeSerializer.class)
    private Date createTime;
    @JsonSerialize(using = DateTimeSerializer.class)
    private Date updateTime;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getFailLoginCount() {
        return failLoginCount;
    }

    public void setFailLoginCount(Integer failLoginCount) {
        this.failLoginCount = failLoginCount;
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