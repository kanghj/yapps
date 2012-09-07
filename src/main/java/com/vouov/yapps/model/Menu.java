package com.vouov.yapps.model;

import java.util.Date;

public class Menu {
    private Integer menuID;

    private String name;

    private String description;

    private Integer parentMenuID;

    private Integer sort;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentMenuID() {
        return parentMenuID;
    }

    public void setParentMenuID(Integer parentMenuID) {
        this.parentMenuID = parentMenuID;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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