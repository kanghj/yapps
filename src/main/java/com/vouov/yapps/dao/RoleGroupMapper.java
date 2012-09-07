package com.vouov.yapps.dao;

import com.vouov.yapps.model.RoleGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleGroupMapper {
    int deleteByPrimaryKey(Integer roleGroupID);

    int insert(RoleGroup record);

    RoleGroup selectByPrimaryKey(Integer roleGroupID);

    List<RoleGroup> selectAll();

    int updateByPrimaryKey(RoleGroup record);
}