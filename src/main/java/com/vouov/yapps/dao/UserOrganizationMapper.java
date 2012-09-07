package com.vouov.yapps.dao;

import com.vouov.yapps.model.UserOrganization;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserOrganizationMapper {
    int deleteByPrimaryKey(Integer userOrgID);

    int insert(UserOrganization record);

    UserOrganization selectByPrimaryKey(Integer userOrgID);

    List<UserOrganization> selectAll();

    int updateByPrimaryKey(UserOrganization record);
}