package com.vouov.yapps.model;

public class UserOrganization {
    private Integer userOrgID;

    private Integer userID;

    private Integer orgID;

    public Integer getUserOrgID() {
        return userOrgID;
    }

    public void setUserOrgID(Integer userOrgID) {
        this.userOrgID = userOrgID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getOrgID() {
        return orgID;
    }

    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }
}