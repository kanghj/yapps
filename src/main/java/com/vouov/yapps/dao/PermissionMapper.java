package com.vouov.yapps.dao;

import com.vouov.yapps.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionID);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer permissionID);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
}