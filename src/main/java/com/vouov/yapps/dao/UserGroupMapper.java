package com.vouov.yapps.dao;

import com.vouov.yapps.model.UserGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserGroupMapper {
    int deleteByPrimaryKey(Integer userGroupID);

    int insert(UserGroup record);

    UserGroup selectByPrimaryKey(Integer userGroupID);

    List<UserGroup> selectAll();

    int updateByPrimaryKey(UserGroup record);
}