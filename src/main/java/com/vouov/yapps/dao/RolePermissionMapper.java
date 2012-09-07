package com.vouov.yapps.dao;

import com.vouov.yapps.model.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rolePermissionID);

    int insert(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolePermissionID);

    List<RolePermission> selectAll();

    int updateByPrimaryKey(RolePermission record);
}