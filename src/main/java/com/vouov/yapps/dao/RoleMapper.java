package com.vouov.yapps.dao;

import com.vouov.yapps.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleID);

    int insert(Role record);

    Role selectByPrimaryKey(Integer roleID);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}