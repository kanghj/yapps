package com.vouov.yapps.dao;

import com.vouov.yapps.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer userRoleID);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(Integer userRoleID);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);
}