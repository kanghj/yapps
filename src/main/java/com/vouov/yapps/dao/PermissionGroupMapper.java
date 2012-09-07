package com.vouov.yapps.dao;

import com.vouov.yapps.model.PermissionGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionGroupMapper {
    int deleteByPrimaryKey(Integer permissionGroupID);

    int insert(PermissionGroup record);

    PermissionGroup selectByPrimaryKey(Integer permissionGroupID);

    List<PermissionGroup> selectAll();

    int updateByPrimaryKey(PermissionGroup record);
}