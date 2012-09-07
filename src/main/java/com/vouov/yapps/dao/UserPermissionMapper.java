package com.vouov.yapps.dao;

import com.vouov.yapps.model.UserPermission;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserPermissionMapper {
    int deleteByPrimaryKey(Integer userPermissionID);

    int insert(UserPermission record);

    UserPermission selectByPrimaryKey(Integer userPermissionID);

    List<UserPermission> selectAll();

    int updateByPrimaryKey(UserPermission record);
}